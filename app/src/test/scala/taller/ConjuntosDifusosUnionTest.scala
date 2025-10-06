package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosUnionTest extends AnyFunSuite {
  val cd = new ConjuntosDifusos

  val pares: cd.ConjDifuso = (x: Int) => if (x % 2 == 0) 1.0 else 0.0
  val multiplosDe3: cd.ConjDifuso = (x: Int) => if (x % 3 == 0) 1.0 else 0.0
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
}