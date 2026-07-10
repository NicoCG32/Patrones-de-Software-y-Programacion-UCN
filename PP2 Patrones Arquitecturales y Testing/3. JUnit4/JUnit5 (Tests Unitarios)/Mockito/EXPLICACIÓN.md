# Explicación Detallada - Dobles de Prueba con Mockito

## Para qué sirve

Mockito crea y configura dobles de prueba para aislar una unidad de sus colaboradores. Permite definir respuestas y verificar interacciones sin ejecutar bases de datos, servicios externos, buses de eventos u otros componentes fuera del objetivo de la prueba.

Un **mock** no es cualquier objeto falso. En sentido estricto, un stub suministra respuestas y un mock verifica interacciones. Mockito soporta ambos usos con la misma API.

## Cómo se usa

El flujo típico es:

1. Crear mocks de puertos o dependencias externas.
2. Construir el objeto bajo prueba con esos mocks.
3. Configurar respuestas necesarias mediante stubbing.
4. Ejecutar una acción.
5. Verificar estado retornado e interacciones relevantes.

```java
when(repositorio.buscarPorId(10L)).thenReturn(Optional.of(solicitud));

servicio.cambiarEstado(10L, EN_REVISION);

verify(repositorio).guardar(solicitud);
verify(notificador).enviar(any(Mensaje.class));
```

No debe configurarse comportamiento que el caso no usa. El stubbing innecesario oculta el escenario. Tampoco debe verificarse cada llamada interna; eso sobreespecifica la implementación.

`ArgumentCaptor` es útil cuando el argumento producido es el resultado relevante. Un `spy` envuelve una instancia real y debe usarse con cautela, porque mezcla comportamiento real y simulado.

## Por qué se usa

Mockito permite probar políticas de coordinación: qué ocurre si un repositorio encuentra o no un dato, qué evento se publica y qué efectos se omiten ante un error. Reduce lentitud e inestabilidad de recursos externos.

No corrige un diseño acoplado. Si una clase necesita numerosos mocks, probablemente posee demasiadas responsabilidades.

## Contextos de aplicación

Es apropiado para servicios de aplicación y componentes que dependen de puertos, clientes o repositorios. No suele ser necesario para objetos de valor, colecciones, entidades simples o funciones puras.

No se deben simular indiscriminadamente tipos que no se controlan o detalles internos del mismo objeto. Para verificar integración con una biblioteca o base de datos se requiere una prueba de integración real.

## Ventajas

- Aislamiento rápido de dependencias.
- Simulación de éxito, ausencia y error.
- Verificación de efectos secundarios.
- Captura de argumentos.
- Buena integración con JUnit.

## Desventajas

- Pruebas frágiles si verifican implementación.
- Riesgo de comportamiento simulado distinto al real.
- Exceso de mocks oculta problemas de diseño.
- Los spies pueden ejecutar efectos inesperados.
- No reemplaza pruebas de contratos e integración.

## Origen y evolución

Los objetos simulados se difundieron con TDD y la escuela londinense de pruebas orientadas a interacciones. Mockito surgió en el ecosistema Java con una API que priorizaba legibilidad: crear, configurar y verificar sin una fase rígida de expectativas previas.

Las versiones posteriores ampliaron soporte para anotaciones, JUnit, clases finales, métodos estáticos y distintos mecanismos de instrumentación. Esta capacidad técnica no implica que todo deba simularse; la recomendación de diseño sigue siendo usar dobles en límites significativos.

## Estado actual

Mockito continúa activamente mantenido y es una herramienta habitual en Java. Su uso moderno favorece:

- Inyección por constructor.
- Mocks de interfaces propias y pequeñas.
- Strict stubbing para detectar configuración innecesaria.
- Verificación de interacciones solo cuando son parte del comportamiento.
- Pruebas de integración para validar el adaptador real.

## Criterio de decisión

Use un objeto real cuando es rápido, determinista y fácil de construir. Use un fake cuando una implementación en memoria aporta una semántica útil. Use Mockito cuando necesita controlar respuestas o inspeccionar una colaboración específica.

## Material de esta carpeta

El [README](README.md) explica `mock`, `when`, `verify`, `never` y `ArgumentCaptor`. Los archivos de `ejemplos/` contrastan cambio de estado exitoso y fallido.

## Referencias

- [Documentación oficial de Mockito](https://site.mockito.org/).
- [Repositorio oficial de Mockito](https://github.com/mockito/mockito).
