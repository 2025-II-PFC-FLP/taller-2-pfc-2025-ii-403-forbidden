package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosComplementoTest extends AnyFunSuite {
    val cj = new ConjuntosDifusos
    import cj._

    test("Complemento de conjunto constante debe devolver valores simétricos a 1") {
        val c1: ConjDifuso = _ => 0.5
        val comp1 = complemento(c1)

        assert(math.abs(comp1(0) - 0.5) < 1e-6)
        assert(math.abs(comp1(100) - 0.5) < 1e-6)
    }

    test("Complemento de conjunto con valores bajos debe ser alto") {
        val c2: ConjDifuso = x => if (x < 10) 0.1 else 0.3
        val comp2 = complemento(c2)

        assert(math.abs(comp2(5) - 0.9) < 1e-6)
        assert(math.abs(comp2(15) - 0.7) < 1e-6)
    }

    test("Complemento de conjunto con valores altos debe ser bajo") {
        val c3: ConjDifuso = x => if (x <= 5) 0.8 else 1.0
        val comp3 = complemento(c3)

        assert(math.abs(comp3(3) - 0.2) < 1e-6)
        assert(math.abs(comp3(6) - 0.0) < 1e-6)
    }

    test("Complemento de función lineal debe decrecer cuando la original crece") {
        val c4: ConjDifuso = x => (x.toDouble / 10.0).min(1.0)
        val comp4 = complemento(c4)

        assert(math.abs(comp4(0) - 1.0) < 1e-6)
        assert(math.abs(comp4(5) - 0.5) < 1e-6)
        assert(math.abs(comp4(10) - 0.0) < 1e-6)
    }

    test("El complemento del complemento debe ser igual al conjunto original") {
        val c5: ConjDifuso = x => if (x % 2 == 0) 0.3 else 0.9
        val comp5 = complemento(c5)
        val dobleComp = complemento(comp5)

        assert(math.abs(dobleComp(2) - c5(2)) < 1e-6)
        assert(math.abs(dobleComp(3) - c5(3)) < 1e-6)
    }
}
