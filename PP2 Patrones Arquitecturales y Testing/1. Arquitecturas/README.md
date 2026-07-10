# Arquitecturas

Esta carpeta reúne ejemplos mínimos de estilos arquitecturales frecuentes. El objetivo no es construir aplicaciones completas, sino mostrar cómo se separan responsabilidades y cómo fluye la dependencia entre componentes.

## Cómo estudiar estos ejemplos

1. Lee primero el README de la arquitectura.
2. Observa qué responsabilidad tiene cada clase.
3. Compila el ejemplo desde su carpeta.
4. Identifica qué dependencia se evita o se controla.
5. Compara el costo adicional con la solución directa.

## Arquitecturas disponibles

| Arquitectura | Explicación | Idea central | Cuándo conviene |
| --- | --- | --- | --- |
| [Basado en capas](<Basado en capas/README.md>) | [Documento conceptual](<Basado en capas/EXPLICACIÓN.md>) | Separar responsabilidades en 2, 3 o N capas. | Sistemas con reglas de negocio y persistencia o servicios externos. |
| [MVC](<MVC/README.md>) | [Documento conceptual](MVC/EXPLICACIÓN.md) | Separar modelo, vista y controlador usando interfaces, CLI o web. | Interfaces donde se quiere aislar estado, presentación y coordinación. |
| [Microservicios](<Microservicios/README.md>) | [Documento conceptual](Microservicios/EXPLICACIÓN.md) | Dividir capacidades de negocio en servicios autónomos. | Sistemas grandes, desplegables por equipos o módulos independientes. |
| [Pipe & Filters](<Pipe & Filters/README.md>) | [Documento conceptual](<Pipe & Filters/EXPLICACIÓN.md>) | Procesar datos como una cadena de transformaciones. | Flujos de limpieza, validación, conversión o enriquecimiento de datos. |
| [Hexagonal](<Hexagonal/README.md>) | [Documento conceptual](Hexagonal/EXPLICACIÓN.md) | Proteger el dominio mediante puertos y adaptadores. | Sistemas que deben cambiar UI, base de datos o integraciones sin tocar reglas centrales. |

## Compilación general

Cada ejemplo usa solo Java estándar. Desde la carpeta de cada arquitectura:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

Las carpetas `Basado en capas` y `MVC` contienen subvariantes. En esos casos se compila desde el `src/` de la subcarpeta correspondiente.

## Criterio académico

Una arquitectura no se evalúa solo por su diagrama. Debe poder justificarse con preguntas concretas:

- Qué responsabilidad queda aislada.
- Qué dependencia se vuelve explícita.
- Qué cambio futuro sería más barato.
- Qué complejidad adicional se introduce.
- Qué regla podría protegerse con ArchUnit o tests unitarios.
