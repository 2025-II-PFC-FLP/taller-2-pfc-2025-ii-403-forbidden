# 📝 Informe de la función `union`

---

## 🧩 Descripción

La unión de dos conjuntos difusos representa el grado de pertenencia de un elemento a **al menos uno de los dos conjuntos**.  
Se define matemáticamente como:

$$
(A \cup B)(x) = \max(A(x), B(x))
$$

---

## ⚙️ Implementación

```scala
def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
  (x: Int) => cd1(x) max cd2(x)
}
```
Esta función devuelve un nuevo conjunto difuso que, al recibir un número entero, calcula el máximo valor de pertenencia entre ambos conjuntos.

---

## 🧪 Casos de prueba

| Elemento | Conjunto 1     | Conjunto 2      | Resultado esperado |
|-----------|----------------|-----------------|--------------------|
| 2         | Par            | Múltiplo de 3   | 1.0                |
| 3         | Par            | Múltiplo de 3   | 1.0                |
| 4         | Par            | Múltiplo de 3   | 1.0                |
| 5         | Par            | Múltiplo de 3   | 0.0                |
| 6         | Par            | Múltiplo de 3   | 1.0                |

---

## 🧠 Conclusión

La función union cumple con las propiedades de los conjuntos difusos y refleja la operación lógica “O”.
Su implementación funcional mediante el operador max permite representar correctamente el principio del máximo grado de pertenencia entre ambos conjuntos.