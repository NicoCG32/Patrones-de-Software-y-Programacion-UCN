# Explicación Detallada - Pruebas Arquitecturales con ArchUnit

## Para qué sirve

ArchUnit permite expresar decisiones de arquitectura como pruebas ejecutables sobre bytecode Java. Verifica dependencias entre paquetes y clases, ciclos, convenciones, capas, anotaciones y otras propiedades estructurales.

Una prueba unitaria responde si una operación produce el comportamiento esperado. Una prueba arquitectural responde si el código conserva límites globales, por ejemplo: “el dominio no depende de infraestructura”.

## Cómo se usa

El proceso básico es:

1. Importar las clases de producción.
2. Seleccionar un conjunto de clases.
3. Definir una condición permitida o prohibida.
4. Ejecutar la regla con JUnit o directamente.
5. Corregir la dependencia, no solo el síntoma del test.

```java
noClasses()
    .that().resideInAPackage("..domain..")
    .should().dependOnClassesThat()
    .resideInAnyPackage("..view..", "..infra..");
```

La regla debe incluir una justificación. Así deja de ser una restricción arbitraria y se convierte en documentación ejecutable.

ArchUnit analiza referencias presentes en clases compiladas: atributos, parámetros, retornos, herencia, anotaciones, construcciones y llamadas. No demuestra que la arquitectura sea buena ni detecta dependencias dinámicas externas que no aparecen en el bytecode.

## Por qué se usa

Los diagramas y convenciones se degradan cuando no existe retroalimentación automática. ArchUnit incorpora la decisión al ciclo de pruebas y CI, haciendo que una violación aparezca en el mismo cambio que la introduce.

## Contextos de aplicación

Es útil en monolitos modulares, arquitecturas por capas, hexagonales, bases de código grandes y migraciones. También puede imponer convenciones, como que controladores terminen en `Controller` o que puertos sean interfaces.

No reemplaza revisión de diseño, pruebas de comportamiento ni análisis de tiempo de ejecución. Tampoco debe congelar una estructura deficiente solo porque es verificable.

## Ventajas

- Reglas arquitecturales automáticas y repetibles.
- Mensajes que identifican dependencias concretas.
- Integración con JUnit y CI.
- Protección frente a degradación gradual.
- Documentación cercana al código.

## Desventajas

- Verifica estructura, no intención completa.
- Reglas por nombres de paquetes pueden ser frágiles.
- Excepciones indiscriminadas erosionan la política.
- Una regla excesiva dificulta refactorizaciones legítimas.
- Requiere clases compiladas para analizar bytecode.

## Origen y evolución

ArchUnit surgió en el ecosistema Java para trasladar pruebas de conformidad arquitectural a la misma infraestructura de tests usada por los equipos. Su API evolucionó desde reglas de dependencias hacia capas, ciclos, slices, condiciones personalizadas y soporte específico para distintas generaciones de JUnit.

La disciplina tiene antecedentes en herramientas de análisis estático y métricas de dependencias. La diferencia pedagógica importante es que ArchUnit permite escribir restricciones en lenguaje cercano al diseño y ejecutarlas como parte del proyecto.

## Estado actual

ArchUnit es una biblioteca activa y estable del ecosistema Java. Su práctica moderna combina:

- Reglas pequeñas con motivos explícitos.
- Paquetes o módulos que representan límites reales.
- CI para impedir nuevas violaciones.
- Congelación temporal de deuda existente durante migraciones.
- Pruebas de ciclos y dependencias entre módulos.

Una regla debe evolucionar cuando cambia una decisión arquitectural legítima. La prueba protege una política; no sustituye la discusión que la define.

## Estrategia de adopción

1. Documentar una regla que el código ya cumple.
2. Agregar reglas críticas de dirección de dependencias.
3. Detectar ciclos.
4. Tratar excepciones como deuda con motivo y plazo.
5. Revisar las reglas junto con cambios de arquitectura.

## Material de esta carpeta

El [README](README.md) contiene sintaxis y casos concretos. Los archivos de `ejemplos/` muestran reglas para MVC, nombres y paquetes.

## Referencias

- [ArchUnit User Guide](https://www.archunit.org/userguide/html/000_Index.html).
- [Sitio oficial de ArchUnit](https://www.archunit.org/).
