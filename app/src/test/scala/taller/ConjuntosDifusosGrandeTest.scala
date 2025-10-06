package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosGrandeTest extends AnyFunSuite {
  val cd = new ConjuntosDifusos
  val grandes = cd.grande(2, 3)

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
    assert(res > 0.95)
  }
}