# Depuración de la versión entregada

El ZIP de partida está roto de forma intencionada: el objetivo del ejercicio es localizar los errores con Logcat y ejecución paso a paso hasta lograr que la suma funcione incluso con la segunda caja vacía.

## Fallos encadenados

1. `tv_resultado` está declarado como `EditText`, aunque `R.id.tv_resultado` corresponde a un `TextView`. La asignación mediante `findViewById` acaba en un `ClassCastException`.
2. `edt_n1` se declara, pero nunca se inicializa con `findViewById`. Tras arreglar el fallo anterior, `edt_n1.addTextChangedListener(...)` provoca un `NullPointerException`.
3. La primera entrada tiene un `try/catch` para el caso vacío, pero la segunda ejecuta directamente `Integer.valueOf(...)`. Dejar la segunda caja vacía provoca `NumberFormatException`, precisamente el caso que el enunciado exige corregir.
4. El `catch (Exception)` de la primera entrada es demasiado amplio y sustituye silenciosamente el texto por `0`.
5. Los controles y textos están fuertemente acoplados al código y la entrega no contiene pruebas útiles.

## Solución modernizada

La versión actual usa View Binding, `TextView` con tipo correcto, ambos inputs enlazados de forma segura y una clase `SumCalculator` independiente. Una caja vacía se interpreta como cero; los números inválidos y el overflow se tratan explícitamente. El `TextWatcher` conserva el comportamiento original de borrar un resultado obsoleto cuando cambia una entrada.
