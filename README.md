# Implementación y análisis de estructuras de datos en Java

**Laboratorio 1 – Estructuras de Datos (2026-2)**
Universidad Nacional de Colombia
**Autor:** Daniel Alejandro Duran Colorado


Este repositorio contiene la implementación en Java de las estructuras de datos `List`, `MyStack<T>` y `MyQueue<T>`, junto con el código usado para medir experimentalmente el tiempo de ejecución de cada uno de sus métodos y compararlo con su complejidad teórica (Big-O).

> Las estructuras se implementaron desde cero, sin usar las colecciones de `java.util` (`ArrayList`, `LinkedList`, `Stack`, etc.).

---

## Estructura del repositorio

```
Implementacion-y-analisis-de-estructuras-de-datos/
├── .vscode/            # Configuración del editor (VS Code)
├── List/               # Implementaciones de la estructura List (listas enlazadas)
├── Queue and Stack/    # Implementaciones de MyStack<T> y MyQueue<T> (arreglo dinámico)
└── README.md
```

### `List/`

Contiene las implementaciones de la estructura `List` basada en listas enlazadas, en sus cuatro variantes:

| Variante | Descripción |
| :--- | :--- |
| Simplemente enlazada **sin cola** | Solo se conserva la referencia a la cabeza (`head`). |
| Simplemente enlazada **con cola** | Se conservan referencias a la cabeza (`head`) y a la cola (`tail`). |
| Doblemente enlazada **sin cola** | Cada nodo apunta al siguiente y al anterior; solo se conserva `head`. |
| Doblemente enlazada **con cola** | Cada nodo apunta al siguiente y al anterior; se conservan `head` y `tail`. |

Métodos implementados en cada variante: `PushFront`, `PushBack`, `PopFront`, `PopBack`, `Find`, `Erase`, `AddBefore`, `AddAfter`, además de métodos auxiliares como `Empty` y `TopBack`.

### `Queue and Stack/`

Contiene las implementaciones de las interfaces `MyStack<T>` y `MyQueue<T>` sobre **arreglo dinámico** (arreglo circular que crece a medida que aumenta el número de elementos).

| Estructura | Métodos |
| :--- | :--- |
| `MyStack<T>` | `push`, `pop`, `peek`, `isEmpty`, `size`, `delete(n)` |
| `MyQueue<T>` | `enqueue`, `dequeue`, `front`, `isEmpty`, `size`, `delete(n)` |

---

## Archivos `Main.java` y medición de tiempos

En cada carpeta hay un archivo `Main.java` que se usó como **plantilla de medición**. Esta plantilla se fue modificando a lo largo del trabajo para ejecutar **método por método** y registrar cuánto tarda cada uno con distintos tamaños de entrada (10², 10³, … hasta 10⁵). Por esta razón, el `main.java` que se encuentra en el repositorio corresponde a la última configuración utilizada y no ejecuta todos los métodos a la vez; para medir otro método basta con cambiar la llamada dentro de la plantilla.

La medición de tiempos se mantiene separada de la graficación de resultados: los gráficos se elaboraron fuera del código, a partir de los datos obtenidos.

---

## Requisitos y ejecución

- JDK 17 o superior (recomendado)
- Cualquier IDE o terminal con soporte para Java (el repositorio incluye configuración de VS Code)

##DISCLAIMER
En el desarrollo de este laboratorio se usaron herramientas de inteligencia artificial. En general esto se usó principalmente para la plantilla del informe y gran parte de este readme.

El código en general no fue tocado por estos agentes, sin embargo si se tomaron sugerencias de parte de estos.
