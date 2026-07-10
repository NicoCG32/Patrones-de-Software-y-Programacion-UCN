# Explicación Detallada - Arquitectura de Dos Capas

## Para qué sirve

La variante de dos capas separa la interacción visible del usuario (**frontend**) de la lógica y acceso a recursos (**backend**). Es el límite mínimo para impedir que presentación, reglas y datos queden mezclados en un único componente.

En este material los términos describen capas lógicas. En una aplicación web suelen corresponder también a despliegues distintos unidos por red, pero no es una condición necesaria.

## Cómo se usa

El frontend:

- Recibe datos y eventos del usuario.
- Valida formato básico para mejorar la experiencia.
- Envía una solicitud mediante un contrato.
- Presenta resultados y errores.

El backend:

- Valida reglas y autorización.
- Coordina casos de uso.
- Accede a datos o integraciones.
- Devuelve una respuesta independiente de detalles visuales.

El contrato debe definir datos, errores y compatibilidad. La validación del frontend no reemplaza la del backend: un cliente puede omitirse o manipularse.

## Por qué y cuándo se usa

Se usa para aplicaciones pequeñas o medianas donde basta un límite cliente-servidor. Permite evolucionar la interfaz sin cambiar las reglas y reutilizar el backend desde varios clientes.

No debe asumirse que “dos capas” implica simplicidad operacional. Si existe red, aparecen autenticación, latencia, versiones, indisponibilidad y serialización.

## Ventajas

- Separación inicial clara.
- Posibilidad de varios clientes.
- Despliegue independiente cuando frontend y backend son tiers distintos.
- Seguridad y reglas centralizadas en el backend.
- Menor complejidad conceptual que modelos con más capas.

## Desventajas

- El backend puede convertirse en una capa monolítica sin estructura interna.
- La frontera remota agrega fallos y versionado.
- Puede duplicarse validación de formato.
- No separa explícitamente aplicación, dominio y persistencia.

## Origen y evolución

Esta variante deriva de arquitecturas cliente-servidor. Las aplicaciones de escritorio conectadas a servidores y bases de datos dieron paso a frontends web y API. La frontera evolucionó desde protocolos específicos hacia HTTP, REST, GraphQL y mensajería.

Cuando el backend crece, suele subdividirse internamente en servicio y persistencia, formando tres o más capas. Esa evolución debe responder a motivos de cambio reales, no a una obligación numérica.

## Estado actual

Frontend/backend continúa siendo una división habitual. En aplicaciones modernas se complementa con contratos versionados, pruebas de contrato y observabilidad. En sistemas pequeños puede ser la estructura suficiente; en sistemas complejos es solo el límite exterior.

## Ejemplo de esta carpeta

El [README](README.md) y `src/Main.java` simulan la llamada desde un frontend hacia un backend. La interfaz Java representa el contrato que en un sistema distribuido se materializaría mediante transporte y serialización.

## Relación con otras variantes

La [explicación general de capas](../EXPLICACIÓN.md) define los principios comunes. La variante de [tres capas](<../3 capas - Vista Servicio Persistencia/EXPLICACIÓN.md>) separa coordinación y datos dentro del backend.
