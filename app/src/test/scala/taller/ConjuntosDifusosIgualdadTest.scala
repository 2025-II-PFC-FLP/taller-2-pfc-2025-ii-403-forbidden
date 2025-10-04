package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosIgualdadTest extends AnyFunSuite {
  val objConjuntosDifusos = new ConjuntosDifusos()
  // Conjunto A
  val conjuntoA: objConjuntosDifusos.ConjDifuso = {
    case 1 => 0.2;
    case 2 => 0.5;
    case 3 => 0.8;
    case 4 => 1.0;
    case _ => 0.0
  }
  // Conjunto B
  val conjuntoB: objConjuntosDifusos.ConjDifuso = {
    case 1 => 0.2;
    case 2 => 0.5;
    case 3 => 0.8;
    case 4 => 1.0;
    case _ => 0.0
  }

  // 1. Conjuntos con elementos comunes
  test("Igualdad de dos conjuntos difusos") {
    assert(objConjuntosDifusos.igualdad(conjuntoA, conjuntoB))
  }

  // 2. Conjunto vacío vs no vacío
  test("Igualdad con conjunto vacío") {
    val conjuntoVacio: objConjuntosDifusos.ConjDifuso = (_: Int) => 0.0
    assert(!objConjuntosDifusos.igualdad(conjuntoA, conjuntoVacio))
  }

  // 3. Conjuntos de misma forma pero diferentes grados
  test("Igualdad de conjuntos con diferentes grados") {
    val conjuntoC: objConjuntosDifusos.ConjDifuso = {
      case 1 => 0.3;
      case 2 => 0.5;
      case 3 => 0.7;
      case 4 => 1.0;
      case _ => 0.0
    }
    assert(!objConjuntosDifusos.igualdad(conjuntoA, conjuntoC))
  }

  // 4. Conjuntos idénticos
  test("Igualdad de conjuntos idénticos") {
    assert(objConjuntosDifusos.igualdad(conjuntoA, conjuntoA))
  }

  // 5. Conjuntos con solapamiento parcial
  test("Igualdad de conjuntos con solapamiento parcial") {
    val conjuntoD: objConjuntosDifusos.ConjDifuso = {
      case 3 => 0.8;
      case 4 => 1.0;
      case 5 => 0.6;
      case _ => 0.0
    }
    assert(!objConjuntosDifusos.igualdad(conjuntoA, conjuntoD))
  }

  // 6. Conjuntos iguales excepto en un punto
  test("Conjuntos iguales excepto en un punto") {
    val conjuntoA: objConjuntosDifusos.ConjDifuso = {
      case 1 => 0.1
      case 2 => 0.4
      case 3 => 0.7
      case _ => 0.0
    }
    val conjuntoB: objConjuntosDifusos.ConjDifuso = {
      case 1 => 0.1
      case 2 => 0.5   // diferente en este punto
      case 3 => 0.7
      case _ => 0.0
    }

    assert(!objConjuntosDifusos.igualdad(conjuntoA, conjuntoB))
  }

  // 7. Conjuntos definidos por tramos
  test("Igualdad de conjuntos definidos por tramos") {
    val conjuntoA: objConjuntosDifusos.ConjDifuso = x => if (x >= 0 && x <= 1000) 0.5 else 0.0
    val conjuntoB: objConjuntosDifusos.ConjDifuso = x => if (x >= 0 && x <= 1000) 0.5 else 0.0

    assert(objConjuntosDifusos.igualdad(conjuntoA, conjuntoB))
  }
}
