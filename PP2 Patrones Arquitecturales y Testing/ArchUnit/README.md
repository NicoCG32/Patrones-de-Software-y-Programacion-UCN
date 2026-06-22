# ArchUnit: tests de arquitectura en Java

## 1. Idea central

ArchUnit permite escribir **reglas arquitecturales ejecutables**. No prueba si un método calcula bien un resultado; prueba si el código respeta decisiones de diseño: qué paquetes pueden depender de cuáles, qué clases deben ser interfaces, qué nombres deben tener ciertos componentes o qué capas deben permanecer aisladas.

En la Formativa PSP, el problema arquitectural principal era este:

```text
controller -> infra.jpa
controller -> infra.external
```

Esa dependencia es peligrosa porque el controlador deja de coordinar la interacción con la vista y empieza a conocer detalles técnicos concretos: JPA, repositorios reales y servicios externos. La regla ArchUnit convierte esa decisión arquitectural en una prueba automática.

## 2. Dependencia Maven usada en la Formativa

El proyecto ya incluye ArchUnit para JUnit 4:

```xml
<dependency>
  <groupId>com.tngtech.archunit</groupId>
  <artifactId>archunit-junit4</artifactId>
  <version>${archunit.version}</version>
  <scope>test</scope>
</dependency>
```

La versión declarada en el `pom.xml` de la Formativa es `1.3.0`.

## 3. Estructura mínima de un test ArchUnit con JUnit 4

```java
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(
        packages = "cl.ucn.solicitudes",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class ArquitecturaMvcTest {

    @ArchTest
    public static final ArchRule regla = noClasses()
            .that().resideInAPackage("..controller..")
            .should().dependOnClassesThat()
            .resideInAnyPackage("..infra..");
}
```

Lectura rigurosa:

- `@RunWith(ArchUnitRunner.class)`: conecta ArchUnit con JUnit 4.
- `@AnalyzeClasses(...)`: indica qué clases del sistema se analizarán.
- `ImportOption.DoNotIncludeTests.class`: evita analizar las clases de test como si fueran producción.
- `@ArchTest`: marca una regla arquitectural ejecutable.
- `ArchRule`: representa una restricción sobre las clases importadas.

## 4. Gramática mental de la sintaxis

La mayoría de reglas se leen como una frase:

```text
selección de clases
    -> filtro sobre esas clases
    -> condición que deben cumplir o no cumplir
    -> justificación arquitectural
```

Ejemplo:

```java
noClasses()
    .that().resideInAPackage("..controller..")
    .should().dependOnClassesThat()
    .resideInAnyPackage("..infra..")
    .because("el controlador no debe depender de infraestructura concreta");
```

Traducción:

```text
Ninguna clase
que resida en un paquete controller
debe depender de clases
que residan en un paquete infra,
porque el controlador debe permanecer libre de detalles técnicos.
```

## 5. Significado de los patrones de paquete

ArchUnit usa patrones parecidos a pointcuts:

```text
..controller..
```

significa:

```text
cualquier paquete que contenga un segmento llamado controller
```

Por ejemplo, coincide con:

```text
cl.ucn.solicitudes.controller
cl.ucn.solicitudes.modulo.controller
```

En cambio:

```text
cl.ucn.solicitudes.controller
```

es mucho más estricto y solo coincide con ese paquete exacto.

## 6. Qué cuenta como dependencia

ArchUnit analiza dependencias en el bytecode. Una dependencia puede aparecer por:

- importar una clase;
- tener un atributo de ese tipo;
- recibir o retornar ese tipo en un método;
- crear una instancia con `new`;
- llamar un método de esa clase;
- extender una clase;
- implementar una interfaz;
- usar una anotación.

Por eso ArchUnit es útil para detectar degradación arquitectural aunque el sistema todavía funcione.

## 7. Reglas útiles para la Formativa PSP

### 7.1. El controlador no debe depender de infraestructura

```java
noClasses()
        .that().resideInAPackage("..controller..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("..infra..")
        .because("el controlador debe delegar casos de uso a application");
```

Uso: detecta si `SolicitudController` conoce `SolicitudRepository`, `EstudianteRepository`, `ServicioCorreoExterno` o clases Vert.x concretas.

### 7.2. La vista no debe depender de JPA

```java
noClasses()
        .that().resideInAPackage("..view..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("..infra.jpa..")
        .because("la vista no debe saber cómo se persisten los datos");
```

Uso: evita que JavaFX o consola creen repositorios directamente.

### 7.3. El dominio no debe depender de capas externas

```java
noClasses()
        .that().resideInAPackage("..domain..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("..controller..", "..view..", "..infra..")
        .because("el dominio debe contener reglas estables, no detalles técnicos");
```

Uso: protege las reglas de negocio. El dominio puede ser usado por otras capas, pero no debe mirar hacia ellas.

### 7.4. Los puertos del dominio deben ser interfaces

```java
classes()
        .that().resideInAPackage("..domain.repository..")
        .should().beInterfaces()
        .because("un puerto define una necesidad, no una implementación");
```

Uso: refuerza la inversión de dependencias:

```text
application -> domain.repository.Port <- infra.jpa.Repository
```

### 7.5. La capa de aplicación no debe depender de JavaFX

```java
noClasses()
        .that().resideInAPackage("..application..")
        .should().dependOnClassesThat()
        .resideInAnyPackage("javafx..", "org.openjfx..")
        .because("los casos de uso deben poder ejecutarse sin interfaz gráfica");
```

Uso: permite probar `SolicitudService` sin levantar UI.

## 8. Cómo interpretar un fallo

Un fallo típico de ArchUnit indica:

```text
Class <cl.ucn.solicitudes.controller.SolicitudController>
depends on <cl.ucn.solicitudes.infra.jpa.SolicitudRepository>
```

Lectura correcta:

1. No significa necesariamente que el método esté mal implementado.
2. Significa que una decisión arquitectural fue violada.
3. La solución no es borrar el test.
4. La solución académicamente correcta es mover la responsabilidad o invertir la dependencia.

En la Formativa, la solución coherente fue:

```text
View -> Controller -> Application Service -> Ports <- Infrastructure
```

## 9. Estrategia de examen

Cuando un test ArchUnit falla:

1. Identifica la clase origen de la dependencia.
2. Identifica la clase destino prohibida.
3. Pregunta: ¿qué capa debería conocer a quién?
4. Si una capa alta conoce infraestructura concreta, introduce un servicio o un puerto.
5. Si el dominio conoce UI, controller o infra, mueve esa lógica fuera del dominio.
6. Ejecuta nuevamente `mvn test`.

## 10. Archivo de ejemplo

Revisa:

```text
ArchUnit/ejemplos/ArquitecturaMvcComentadaTest.java
ArchUnit/ejemplos/NombresYPaquetesArchUnitComentadoTest.java
```

Ambos archivos están comentados y pueden copiarse a:

```text
Formativa 2026-I/src/test/java/cl/ucn/solicitudes/architecture/
```

## 11. Fuentes primarias consultadas

- ArchUnit User Guide: https://www.archunit.org/userguide/html/000_Index.html
- ArchUnit JUnit 4 en Maven Central, usado por el proyecto mediante `archunit-junit4`.
- Formativa PSP local: `Formativa 2026-I/src/test/java/cl/ucn/solicitudes/architecture/ArquitecturaMvcTest.java`.
