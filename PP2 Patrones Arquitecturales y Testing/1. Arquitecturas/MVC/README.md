# MVC

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Separar el estado del sistema, la presentación y la coordinación de acciones del usuario.

## Variantes incluidas

| Variante | Estructura | Idea principal |
| --- | --- | --- |
| [MVC con interfaces](<MVC con interfaces/README.md>) | `View interface -> Controller interface -> Model interface` | Usar contratos para desacoplar implementaciones concretas. |
| [MVC CLI](<MVC CLI/README.md>) | `CLI View -> Controller -> Model` | Aplicar MVC en consola sin interfaz gráfica. |
| [MVC Web](<MVC Web/README.md>) | `HTTP Request -> Controller -> Model -> View Template` | Simular MVC web sin framework externo. |

## Ejemplo base

El ejemplo de `src/` muestra un contador simple:

```text
Vista -> Controlador -> Modelo
Vista <- Controlador <- Modelo
```

- `ContadorModel`: mantiene el estado.
- `ContadorView`: muestra información y simula una acción de usuario.
- `ContadorController`: interpreta la acción y actualiza el modelo.

## Regla de dependencia

La vista no modifica el modelo directamente. El controlador traduce la intención del usuario en operaciones sobre el modelo.

## Ejecución del ejemplo base

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

Cada variante tiene su propio `README.md` y su propio `src/Main.java`.

## Lectura académica

MVC no significa necesariamente interfaz gráfica. También puede aplicarse a consola o web. Lo esencial es separar:

- modelo: estado y reglas;
- vista: presentación;
- controlador: traducción de entradas en operaciones.
