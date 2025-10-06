# 📝 Informe de la función `pertenece`

---

## 🧩 Descripción

La función `pertenece` determina el **grado de pertenencia** de un elemento dentro de un conjunto difuso.  
En los conjuntos difusos, cada elemento tiene un valor entre 0 y 1 que representa cuánto pertenece al conjunto.

$$
\text{pertenece}(x, A) = A(x)
$$

Esto significa que simplemente se evalúa la función difusa \( A \) en el punto \( x \).

---

## ⚙️ Implementación

```scala
def pertenece(elem: Int, s: ConjDifuso): Double = s(elem)
```
Esta implementación aplica directamente la función s (que representa el conjunto difuso) al elemento dado.

---

## 🧪 Casos de prueba

| Elemento  | Conjunto      | Resultado esperado |
|-----------|---------------|--------------------|
| 2         | Pares         | 1.0                |
| 3         | Pares         | 0                  |
| 7         | Mayores que 5 | 1.0                |
| 5         | Mayores que 5 | 0                  |
| 10        | Mayores que 5 | 1.0                |

---

## 🧠 Conclusión

La función pertenece demuestra la base de los conjuntos difusos:
no existe pertenencia binaria (sí/no), sino un grado de pertenencia continuo.
Su implementación, al ser una simple aplicación de función, mantiene un enfoque puro, declarativo y funcional.

