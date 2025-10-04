
---

# Informe de proceso Algoritmo Complemento en Conjuntos Difusos

## Definición del Algoritmo

```Scala
package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double

  def complemento(c: ConjDifuso): ConjDifuso = {
    elem => {
      val grado = c(elem)
      val complemento = 1.0 - grado
      complemento
    }
  }
}
```

* El algoritmo **invierte el grado de pertenencia** de cada elemento dentro del conjunto difuso.
* Se basa en la operación matemática ( f_{\neg A}(x) = 1 - f_A(x) ).
* No utiliza bucles, mutabilidad ni estructuras iterativas.
* Cada evaluación tiene **complejidad constante O(1)**.

---

## Explicación paso a paso

### Definición de operación

```Scala
val grado = c(elem)
val complemento = 1.0 - grado
complemento
```

* Se toma el grado de pertenencia del elemento `elem` aplicando la función `c`.
* Se calcula su complemento restando el valor obtenido de 1.
* El resultado es el nuevo grado de pertenencia del elemento en el conjunto complementario.

---

## Representación matemática

[
f_{\neg A}(x) = 1 - f_A(x)
]

donde:

* ( f_A(x) \in [0,1] ) es el grado de pertenencia original,
* ( f_{\neg A}(x) \in [0,1] ) es el grado de pertenencia al complemento.

**Ejemplo:**

[
f_A(4) = 0.8 \Rightarrow f_{\neg A}(4) = 1 - 0.8 = 0.2
]

---

## Llamados de función

Ejemplo con un conjunto difuso definido como:

```Scala
val cj = new ConjuntosDifusos
val c: cj.ConjDifuso = x => if (x < 5) 0.2 else 0.9
val comp = cj.complemento(c)
```

### Paso 1: Evaluación inicial

* Para ( x = 2 ): ( f_A(2) = 0.2 )
* Para ( x = 7 ): ( f_A(7) = 0.9 )

### Paso 2: Aplicación de la función complemento

[
f_{\neg A}(2) = 1 - 0.2 = 0.8
]
[
f_{\neg A}(7) = 1 - 0.9 = 0.1
]

---

## Ejemplo de uso

```Scala
val cj = new ConjuntosDifusos
val conjunto: cj.ConjDifuso = x => if (x <= 5) 0.3 else 0.7
val complemento = cj.complemento(conjunto)

println(complemento(2))  // 0.7
println(complemento(8))  // 0.3
```

El resultado cumple que los grados de pertenencia se invierten de manera proporcional dentro del rango [0,1].

---

## Diagrama de flujo del algoritmo

```mermaid
flowchart TD
    A[Inicio] --> B[Recibir conjunto difuso c]
    B --> C[Evaluar elemento x]
    C --> D[Obtener grado = c(x)]
    D --> E[Calcular complemento = 1 - grado]
    E --> F[Retornar f¬A(x)]
    F --> G[Fin]
```

---

## Análisis de complejidad

El algoritmo evalúa una sola operación por elemento, por lo tanto:

[
T(n) = O(1)
]

No hay recursión ni estructuras iterativas, y la función es pura e inmutable.

---