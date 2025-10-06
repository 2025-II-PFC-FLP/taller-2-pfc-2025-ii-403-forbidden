package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosPertenenciaTest extends AnyFunSuite {
  val cd = new ConjuntosDifusos

  val pares: cd.ConjDifuso = (x: Int) => if (x % 2 == 0) 1.0 else 0.0
  val mayoresQue5: cd.ConjDifuso = (x: Int) => if (x > 5) 1.0 else 0.0

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
}
