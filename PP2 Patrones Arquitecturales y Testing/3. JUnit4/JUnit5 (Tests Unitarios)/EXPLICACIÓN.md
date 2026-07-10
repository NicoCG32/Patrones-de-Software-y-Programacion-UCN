# Explicación Detallada - Pruebas Unitarias con JUnit

## Para qué sirve

JUnit proporciona el modelo de ejecución, anotaciones y aserciones para automatizar pruebas en Java. Una prueba unitaria verifica una unidad de comportamiento de forma rápida, determinista y aislada de recursos innecesarios.

“Unidad” no equivale obligatoriamente a método o clase. Puede ser una regla observable implementada por varias clases pequeñas. El aislamiento debe apoyar claridad, no obligar a simular toda colaboración.

## Cómo se usa

Una prueba rigurosa sigue una estructura como AAA:

1. **Arrange**: preparar datos y dependencias.
2. **Act**: ejecutar una acción relevante.
3. **Assert**: verificar el resultado observable.

Los nombres deben expresar condición y resultado. Deben cubrir caminos válidos, límites y errores. Una buena prueba controla el tiempo, aleatoriedad, archivos, red y estado global cuando estos afectarían su repetibilidad.

JUnit 4 utiliza `@Test`, `@Before`, reglas y runners. JUnit Jupiter, introducido con JUnit 5, usa un modelo de extensiones, pruebas parametrizadas y anotaciones como `@BeforeEach`. No deben mezclarse imports de ambas generaciones sin una configuración deliberada.

## Por qué se usa

Las pruebas entregan retroalimentación rápida, documentan reglas y permiten refactorizar con evidencia. También ayudan a diseñar componentes cohesionados: una unidad difícil de preparar suele revelar dependencias ocultas o demasiadas responsabilidades.

Las pruebas no demuestran ausencia total de defectos. Un conjunto puede estar verde y omitir comportamientos importantes.

## Contextos de aplicación

Son apropiadas para entidades, objetos de valor, algoritmos, servicios de aplicación y adaptadores con dependencias controladas. Deben complementarse con pruebas de integración, contrato y sistema cuando intervienen base de datos, red, framework o múltiples procesos.

## Ventajas

- Retroalimentación rápida y localizada.
- Documentación ejecutable del comportamiento.
- Detección de regresiones.
- Soporte para refactorización.
- Diseño más explícito de dependencias.

## Desventajas

- Requieren mantenimiento.
- Las pruebas acopladas a implementación dificultan cambios.
- Un exceso de mocks puede validar una ficción.
- Cobertura alta no garantiza casos significativos.
- Pruebas no deterministas reducen confianza.

## Origen y evolución

JUnit fue creado por Kent Beck y Erich Gamma a fines de la década de 1990, inspirado en SUnit y la familia xUnit. Popularizó pruebas automatizadas cercanas al código Java y se volvió una pieza central de desarrollo guiado por pruebas.

JUnit 4 adoptó anotaciones y runners, eliminando convenciones y herencia requeridas por generaciones anteriores. JUnit 5 rediseñó el proyecto en tres componentes:

- **JUnit Platform**: descubrimiento y ejecución.
- **JUnit Jupiter**: API y motor moderno.
- **JUnit Vintage**: compatibilidad con pruebas antiguas.

La línea actual conserva esa separación de plataforma y motores. El material de esta carpeta utiliza JUnit 4 por compatibilidad académica, pero explica conceptos transferibles.

## Estado actual

JUnit continúa siendo el estándar de facto para pruebas Java. Los proyectos nuevos suelen usar Jupiter o la versión vigente de la plataforma; bases heredadas pueden ejecutar JUnit 4 durante una migración gradual.

La evolución actual pone énfasis en extensiones, parametrización, ejecución paralela, integración con IDE y herramientas de construcción. La recomendación académica es aprender primero independencia, observabilidad y diseño de casos; la sintaxis de versión es secundaria.

## Qué constituye una buena prueba

- Verifica una conducta relevante.
- Falla por una razón clara.
- No depende del orden de otras pruebas.
- Tiene datos mínimos y legibles.
- Evita sleeps, reloj real y red si no son el objetivo.
- Comprueba efectos y ausencia de efectos cuando corresponde.

## Material de esta carpeta

El [README](README.md) desarrolla JUnit 4 y la estructura AAA. `ejemplos/` contiene pruebas puras del dominio. [Mockito](Mockito/EXPLICACIÓN.md) se estudia aparte para aislar colaboradores externos.

## Referencias

- [Documentación de JUnit 4](https://junit.org/junit4/).
- [Guía actual de JUnit](https://docs.junit.org/current/user-guide/).
