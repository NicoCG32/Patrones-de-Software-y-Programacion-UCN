# Patrones de Software y Programación - UCN

![Java](https://img.shields.io/badge/Java-seg%C3%BAn%20proyecto-ED8B00?logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-000000?logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)
![Testing](https://img.shields.io/badge/Testing-JUnit%20%7C%20Mockito%20%7C%20ArchUnit-25A162)
![Nivel](https://img.shields.io/badge/Nivel-3%20Arquitectura%20y%20patrones-purple)

Repositorio de apoyo para el curso **Patrones de Software y Programación** de la Universidad Católica del Norte.

Este repositorio nació como material de estudio personal, por lo que su valor principal está en la explicación progresiva de patrones, ejemplos implementados y apuntes de testing/arquitectura. Esta portada organiza ese material con una estructura similar a los otros repositorios de cursos.

## Entorno del curso

El curso se desarrolla principalmente en **Java**, usando **IntelliJ IDEA** como IDE. La versión exacta de Java puede variar, porque normalmente viene dada por el proyecto, taller o evaluación que se esté trabajando.

En este repositorio aparecen proyectos con Maven, pruebas unitarias, dobles de prueba, reglas arquitecturales y ejemplos de comunicación reactiva. Por eso el entorno debe permitir revisar código Java, ejecutar tests y navegar proyectos con múltiples paquetes y capas.

## Estructura

```text
Patrones-de-Software-y-Programacion-UCN/
├── PP1 Patrones de diseño GoF/
│   ├── 1. Creacionales/
│   ├── 2. Estructurales/
│   └── 3. Comportamentales/
├── PP2 Patrones Arquitecturales y Testing/
│   ├── 1. Arquitecturas/
│   │   ├── Basado en capas/
│   │   ├── MVC/
│   │   ├── Microservicios/
│   │   ├── Pipe & Filters/
│   │   └── Hexagonal/
│   ├── 2. ArchUnit (Tests Arquitecturales)/
│   ├── 3. JUnit4/
│   │   └── JUnit5 (Tests Unitarios)/
│   │       └── Mockito/
│   └── 4. ProgramacionReactiva/
└── README.md
```

Cada tema contiene un `README.md` operativo y un `EXPLICACIÓN.md` conceptual. El segundo desarrolla propósito, uso, contexto, ventajas, limitaciones, origen, evolución y estado actual.

## Material implementado

### PP1: Patrones de diseño GoF

| Familia | Patrones disponibles | Propósito general |
| --- | --- | --- |
| Creacionales | [Abstract Factory](<PP1 Patrones de diseño GoF/1. Creacionales/Abstract Factory/README.md>), [Builder](<PP1 Patrones de diseño GoF/1. Creacionales/Builder/README.md>), [Factory Method](<PP1 Patrones de diseño GoF/1. Creacionales/Factory Method/README.md>), [Prototype](<PP1 Patrones de diseño GoF/1. Creacionales/Prototype/README.md>), [Singleton](<PP1 Patrones de diseño GoF/1. Creacionales/Singleton/README.md>) | Organizar la creación de objetos sin acoplar el código cliente a clases concretas innecesariamente. |
| Estructurales | [Adapter](<PP1 Patrones de diseño GoF/2. Estructurales/Adapter/README.md>), [Decorator](<PP1 Patrones de diseño GoF/2. Estructurales/Decorator/README.md>), [Facade](<PP1 Patrones de diseño GoF/2. Estructurales/Facade/README.md>), [Proxy](<PP1 Patrones de diseño GoF/2. Estructurales/Proxy/README.md>) | Componer clases y objetos para adaptar interfaces, simplificar subsistemas o agregar responsabilidades. |
| Comportamentales | [Observer](<PP1 Patrones de diseño GoF/3. Comportamentales/Observer/README.md>), [Strategy](<PP1 Patrones de diseño GoF/3. Comportamentales/Strategy/README.md>), [Template Method](<PP1 Patrones de diseño GoF/3. Comportamentales/Template Method/README.md>), [Visitor](<PP1 Patrones de diseño GoF/3. Comportamentales/Visitor/README.md>) | Distribuir comportamiento, encapsular variaciones y coordinar la comunicación entre objetos. |

Cada patrón puede incluir:

- Explicación conceptual.
- Diagrama UML en `.puml` o imagen.
- Ejemplo genérico de implementación.
- Ejemplos aplicados a problemas concretos.

### PP2: Patrones arquitecturales y testing

| Material | Contenido principal |
| --- | --- |
| [Arquitecturas](<PP2 Patrones Arquitecturales y Testing/1. Arquitecturas/README.md>) | Ejemplos genéricos de arquitectura basada en capas, MVC, microservicios, Pipe & Filters y arquitectura hexagonal. |
| [Basado en capas](<PP2 Patrones Arquitecturales y Testing/1. Arquitecturas/Basado en capas/README.md>) | Separación entre presentación, aplicación, dominio e infraestructura. |
| [MVC](<PP2 Patrones Arquitecturales y Testing/1. Arquitecturas/MVC/README.md>) | Separación entre modelo, vista y controlador. |
| [Microservicios](<PP2 Patrones Arquitecturales y Testing/1. Arquitecturas/Microservicios/README.md>) | División de capacidades de negocio en servicios autónomos. |
| [Pipe & Filters](<PP2 Patrones Arquitecturales y Testing/1. Arquitecturas/Pipe & Filters/README.md>) | Procesamiento de datos mediante una cadena de filtros independientes. |
| [Hexagonal](<PP2 Patrones Arquitecturales y Testing/1. Arquitecturas/Hexagonal/README.md>) | Dominio protegido mediante puertos y adaptadores. |
| [ArchUnit](<PP2 Patrones Arquitecturales y Testing/2. ArchUnit %28Tests Arquitecturales%29/README.md>) | Tests de arquitectura, reglas ejecutables sobre dependencias, paquetes, capas y convenciones. |
| [JUnit4](<PP2 Patrones Arquitecturales y Testing/3. JUnit4/JUnit5 %28Tests Unitarios%29/README.md>) | Tests unitarios, estructura AAA, aserciones, casos de error y reglas de negocio. |
| [Mockito](<PP2 Patrones Arquitecturales y Testing/3. JUnit4/JUnit5 %28Tests Unitarios%29/Mockito/README.md>) | Dobles de prueba, mocks, stubs, `verify`, `never` y `ArgumentCaptor`. |
| [Programación Reactiva](<PP2 Patrones Arquitecturales y Testing/4. ProgramacionReactiva/README.md>) | Vert.x, Event Bus, point-to-point, publish-subscribe y request-response. |

## Temario del curso

| Unidad | Contenidos |
| --- | --- |
| 1. Fundamentos de diseño | Acoplamiento, cohesión, responsabilidad, dependencia, interfaz, implementación y separación de capas. |
| 2. Patrones creacionales | Abstract Factory, Builder, Factory Method, Prototype y Singleton. |
| 3. Patrones estructurales | Adapter, Decorator, Facade y Proxy. |
| 4. Patrones comportamentales | Observer, Strategy, Template Method y Visitor. |
| 5. Arquitectura de software | Organización por capas, MVC, servicios de aplicación, dominio, infraestructura y puertos. |
| 6. Testing unitario | JUnit4, aserciones, pruebas de reglas de negocio, pruebas de error y estructura AAA. |
| 7. Dobles de prueba | Mockito, mocks, stubs, verificación de interacciones y aislamiento de dependencias externas. |
| 8. Validación arquitectural | ArchUnit, reglas ejecutables, restricciones entre paquetes y protección contra degradación arquitectural. |
| 9. Programación reactiva | Vert.x, Event Bus, mensajes, eventos, publish-subscribe, point-to-point y request-response. |
| 10. Cobertura y calidad | Maven, JaCoCo, criterios mínimos de cobertura y justificación técnica de decisiones de diseño. |

## Cómo estudiar este repositorio

1. Parte por la carpeta [PP1 Patrones de diseño GoF](<PP1 Patrones de diseño GoF/README.md>) para entender la taxonomía de patrones.
2. Estudia cada patrón desde su problema: qué necesidad resuelve, qué clases introduce y qué dependencia evita o controla.
3. Revisa los ejemplos implementados después de leer el README del patrón.
4. Pasa a [PP2 Patrones Arquitecturales y Testing](<PP2 Patrones Arquitecturales y Testing/>) cuando ya tengas claridad sobre composición de clases.
5. En PP2, sigue el orden enumerado: [Arquitecturas](<PP2 Patrones Arquitecturales y Testing/1. Arquitecturas/README.md>), ArchUnit, JUnit4 con Mockito y Programación Reactiva.

La idea no es memorizar nombres de patrones. Un patrón se entiende bien cuando puedes explicar el problema que resuelve, el costo que agrega y por qué esa estructura es mejor que una solución directa en ese contexto.

## Nota sobre niveles de abstracción

Patrones de Software y Programación corresponde al **nivel 3** de la progresión. En este punto ya no se piensa principalmente en líneas de código, clases aisladas o estructuras de datos individuales, sino en **componentes** y en la forma en que esos componentes colaboran para formar una arquitectura.

Un patrón no es una receta rígida ni una obligación estética. Es una respuesta documentada a un problema recurrente de diseño. Su valor aparece cuando ayuda a ordenar responsabilidades, reducir acoplamiento, encapsular variaciones o hacer explícitas las reglas de comunicación entre partes del sistema.

La progresión completa puede leerse así:

| Nivel | Curso o enfoque | Forma principal de pensar |
| --- | --- | --- |
| 0 | [Programación](https://github.com/NicoCG32/Programacion-UCN) | Líneas de código, instrucciones, pasos directos y algoritmos básicos. |
| 1 | [Programación Orientada a Objetos](https://github.com/NicoCG32/Programacion-Orientada-a-Objetos-UCN) y [Técnicas y Metodologías](https://github.com/NicoCG32/Tecnicas-y-Metodologias-de-Programacion-Avanzada-UCN) | Dominio, clases, objetos, relaciones y componentes básicos. |
| 2 | [Estructura de Datos](https://github.com/NicoCG32/Estructura-de-Datos-UCN) | Contenedores, organización de datos, invariantes y algoritmos sobre estructuras. |
| 3 | [Patrones de Software y Programación](https://github.com/NicoCG32/Patrones-de-Software-y-Programacion-UCN) | Componentes, composición de clases, dependencias y arquitectura de software. |

En este nivel, diseñar bien significa decidir cómo se separan las responsabilidades, qué dependencias son aceptables, qué variaciones deben encapsularse y qué reglas del sistema deben protegerse con pruebas. La arquitectura no aparece como una capa decorativa: aparece como consecuencia de organizar muchas clases para que el software pueda crecer sin volverse frágil.
