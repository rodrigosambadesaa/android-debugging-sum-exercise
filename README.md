# Android Debugging Sum Exercise

Solución moderna del ejercicio **Corrección de errores** de Desarrollo de Interfaces. El proyecto original se entrega deliberadamente con varios fallos y debe depurarse hasta sumar dos enteros correctamente, incluido el caso en que la segunda caja queda vacía.

## Resultado final

- Dos entradas de enteros con signo.
- Una entrada vacía equivale a `0`.
- Al cambiar cualquier entrada se borra el resultado anterior.
- Los valores no numéricos y el overflow se comunican al usuario.
- La lógica de parsing/suma se prueba de forma independiente.

## Modernización

Java 17, AGP 9.3.0, Gradle 9.5.0, compile/target SDK 37, minSdk 23, AppCompat 1.8.0, View Binding, JUnit y GitHub Actions.

La secuencia de bugs de la entrega original está explicada en [`docs/ORIGINAL_REVIEW.md`](docs/ORIGINAL_REVIEW.md), para que el repositorio siga sirviendo como ejercicio de depuración y no solo como “solución final”.
