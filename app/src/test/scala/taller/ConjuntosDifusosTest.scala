package taller
import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {
  val cd = new ConjuntosDifusos

  val pares: cd.ConjDifuso = (x: Int) => if (x % 2 == 0) 1.0 else 0.0
  val multiplosDe3: cd.ConjDifuso = (x: Int) => if (x % 3 == 0) 1.0 else 0.0
  val mayoresQue5: cd.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.0

  //tests de pertenece
  test("Pertenencia: 2 pertenece al conjunto de pares") {
    assert(cd.pertenece(2, pares) == 1.0)
  }

  test("Pertenencia: 3 no pertenece al conjunto de pares") {
    assert(cd.pertenece(3, pares) == 0.0)
  }

  test("Pertenencia: 7 pertenece al conjunto de mayores que 5") {
    assert(cd.pertenece(7, mayoresQue5) == 1.0)
  }

  test("Pertenencia: 5 no pertenece al conjunto de mayores que 5") {
    assert(cd.pertenece(5, mayoresQue5) == 0.0)
  }

  test("Pertenencia: 10 pertenece al conjunto de mayores que 5") {
    assert(cd.pertenece(10, mayoresQue5) == 1.0)
  }

  //test de union
  val unionParesMultiplos3 = cd.union(pares, multiplosDe3)

  test("Union: 2 pertenece porque es par") {
    assert(cd.pertenece(2, unionParesMultiplos3) == 1.0)
  }

  test("Union: 3 pertenece porque es múltiplo de 3") {
    assert(cd.pertenece(3, unionParesMultiplos3) == 1.0)
  }

  test("Union: 4 pertenece porque es par") {
    assert(cd.pertenece(4, unionParesMultiplos3) == 1.0)
  }

  test("Union: 5 no pertenece porque no es par ni múltiplo de 3") {
    assert(cd.pertenece(5, unionParesMultiplos3) == 0.0)
  }

  test("Union: 6 pertenece porque es par y múltiplo de 3") {
    assert(cd.pertenece(6, unionParesMultiplos3) == 1.0)
  }

  //tests de grande
  val grandes = cd.grande(2, 3) // d = 2, e = 3

  test("Grande: un número negativo no se considera grande") {
    assert(grandes(-5) == 0.0)
  }

  test("Grande: 0 no se considera grande") {
    assert(grandes(0) == 0.0)
  }

  test("Grande: el grado de pertenencia de 1 es mayor que 0 pero menor que 1") {
    val res = grandes(1)
    assert(res > 0.0 && res < 1.0)
  }

  test("Grande: a mayor número, mayor grado de pertenencia") {
    assert(grandes(10) > grandes(5))
  }

  test("Grande: números muy grandes se acercan a 1") {
    val res = grandes(1000)
    assert(res > 0.95) // suficientemente cercano a 1
  }

  test("Grande: valores negativos no se consideran grandes") {
    assert(grandes(-5) == 0.0)
  }








}
