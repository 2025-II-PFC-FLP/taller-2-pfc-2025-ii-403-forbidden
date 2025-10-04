package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosInclusionTest extends AnyFunSuite {
    val cj = new ConjuntosDifusos
    import cj._

    test("Un conjunto idéntico está incluido en sí mismo") {
        val cd1: ConjDifuso = x => if (x < 10) 0.3 else 0.8
        assert(inclusion(cd1, cd1))
    }

    test("Conjunto con valores menores está incluido en el que tiene mayores") {
        val cd1: ConjDifuso = x => if (x < 10) 0.2 else 0.5
        val cd2: ConjDifuso = x => if (x < 10) 0.4 else 0.7
        assert(inclusion(cd1, cd2))
    }

    test("Conjunto con valores mayores no está incluido en el menor") {
        val cd1: ConjDifuso = x => if (x < 10) 0.8 else 0.9
        val cd2: ConjDifuso = x => if (x < 10) 0.5 else 0.7
        assert(!inclusion(cd1, cd2))
    }

    test("Inclusión debe cumplirse incluso con funciones no constantes") {
        val cd1: ConjDifuso = x => (x.toDouble / 100.0).min(1.0)
        val cd2: ConjDifuso = x => (x.toDouble / 50.0).min(1.0)
        assert(inclusion(cd1, cd2))
    }

    test("Inclusión debe fallar si un solo valor no cumple la relación") {
        val cd1: ConjDifuso = x => if (x == 500) 0.9 else 0.2
        val cd2: ConjDifuso = _ => 0.8
        assert(!inclusion(cd1, cd2))
    }
}