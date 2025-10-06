[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/lEw1Qm1j)
# Asignación: Funciones de alto orden, Conjuntos Difusos

**Fecha:** 23/09/2025
**Curso:** Fundamentos de Programación Funcional y Concurrente

---

## 👥 Integrantes del Grupo

| Nombre Completo | Código | Rol            | Correo Electrónico        |
| --------------- | ------ | -------------- | ------------------------- |
| Angel Nicolas Castañeda Valencia  | 202459426 | [Líder/Colab.] | castaneda.angel@correounivalle.edu.co |
| Karen Andrea Sanabria Gonzalez  | 202459413 | [Colaborador]  | karen.sanabria@correounivalle.edu.co |
| Simon David Tarazona Melo  | 202459421| [Colaborador]  | simon.tarazona@correounivalle.edu.co |

---

## 📌 Descripción de la Asignación
---
Este taller busca **implementar y analizar operaciones fundamentales sobre conjuntos difusos** utilizando el lenguaje **Scala** y los principios de la **programación funcional**.

Los conjuntos difusos permiten representar grados de pertenencia entre `0` y `1`, ampliando el concepto clásico de conjunto.
El proyecto se basa en las ideas de *Lotfi Zadeh (1965)* y aplica conceptos como **funciones de alto orden**, **recursión de cola**, y **análisis de complejidad algorítmica**.

---

## 🎯 Objetivos

* Implementar funciones para la creación, combinación y comparación de conjuntos difusos.
* Aplicar conceptos de programación funcional sin utilizar bucles ni variables mutables.
* Analizar las operaciones mediante su complejidad y comportamiento recursivo.
* Representar gráficamente las pilas de llamadas con diagramas **Mermaid**.
* Documentar los procesos usando **Markdown** y **LaTeX** para notación matemática.

---

## ⚙️ Funciones Implementadas

### 1. `grande(d, e)`

* Define un conjunto difuso de números grandes.
* Utiliza la expresión $(\frac{n}{n + d})^e) para calcular el grado de pertenencia.
* Permite ajustar los parámetros de crecimiento mediante los valores `d` y `e`.

---

### 2. `complemento(c)`

* Calcula el complemento de un conjunto difuso.
* Se basa en la función $f_{\neg S}(x) = 1 - f_S(x)$.
* Devuelve un nuevo conjunto difuso con los grados de pertenencia invertidos.

---

### 3. `union(cd1, cd2)`

* Devuelve la unión de dos conjuntos difusos.
* Utiliza la operación $f_{S1 \cup S2}(x) = \max(f_{S1}(x), f_{S2}(x))$.
* Representa el grado máximo de pertenencia de ambos conjuntos.

---

### 4. `interseccion(cd1, cd2)`

* Calcula la intersección entre dos conjuntos difusos.
* Emplea $f_{S1 \cap S2}(x) = \min(f_{S1}(x), f_{S2}(x))$.
* Devuelve el valor mínimo de pertenencia común.

---

### 5. `inclusion(cd1, cd2)`

* Determina si un conjunto difuso está incluido en otro.
* Usa recursión de cola para recorrer los valores dentro del rango `[0, 1000]`.
* Verifica que $f_{S1}(x) \le f_{S2}(x)$ para todo `x`.

---

### 6. `igualdad(cd1, cd2)`

* Comprueba si dos conjuntos difusos son equivalentes.
* Se cumple si $( S1 \subseteq S2 )$ y $( S2 \subseteq S1 )$.
* Implementa recursión y comparación por grados de pertenencia.

---

¿Quieres que también te dé la sección de **👥 Integrantes del grupo** al final (con formato de tabla Markdown) para que la pegues directamente en el README?
