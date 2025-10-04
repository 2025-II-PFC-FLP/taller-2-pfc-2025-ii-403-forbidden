package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosInterseccionTest extends AnyFunSuite {
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
    case 3 => 0.6;
    case 4 => 0.9;
    case 5 => 1.0;
    case _ => 0.0
  }

  // 1. Conjuntos con elementos comunes
  test("Intersección de dos conjuntos difusos") {
    val interseccion = objConjuntosDifusos.interseccion(conjuntoA, conjuntoB)
    assert(interseccion(1) == 0.0)
    assert(interseccion(2) == 0.0)
    assert(interseccion(3) == Math.min(0.8, 0.6))
    assert(interseccion(4) == Math.min(1.0, 0.9))
    assert(interseccion(5) == 0.0)
    assert(interseccion(6) == 0.0)
  }

  // 2. Conjunto vacío
  test("Intersección con conjunto vacío") {
    val conjuntoVacio: objConjuntosDifusos.ConjDifuso = (_: Int) => 0.0
    val interseccion = objConjuntosDifusos.interseccion(conjuntoA, conjuntoVacio)
    assert(interseccion(1) == 0.0)
    assert(interseccion(3) == 0.0)
    assert(interseccion(4) == 0.0)
  }

  // 3. Conjuntos idénticos
  test("Intersección de conjuntos idénticos") {
    val interseccion = objConjuntosDifusos.interseccion(conjuntoA, conjuntoA)
    assert(interseccion(1) == 0.2)
    assert(interseccion(2) == 0.5)
    assert(interseccion(3) == 0.8)
    assert(interseccion(4) == 1.0)
  }

  // 4. Conjuntos sin solapamiento
  test("Intersección sin solapamiento") {
    val conjuntoC: objConjuntosDifusos.ConjDifuso = (x: Int) => if (x == 6) 0.4 else if (x == 7) 0.7 else 0.0
    val interseccion = objConjuntosDifusos.interseccion(conjuntoA, conjuntoC)
    assert(interseccion(6) == 0.0)
    assert(interseccion(7) == 0.0)
  }

  // 5. Conjuntos parcialmente solapados
  test("Intersección parcial") {
    val conjuntoD: objConjuntosDifusos.ConjDifuso = {
      case 2 => 0.3;
      case 3 => 0.7;
      case 4 => 0.5;
      case _ => 0.0
    }
    val interseccion = objConjuntosDifusos.interseccion(conjuntoA, conjuntoD)
    assert(interseccion(2) == Math.min(0.5, 0.3))
    assert(interseccion(3) == Math.min(0.8, 0.7))
    assert(interseccion(4) == Math.min(1.0, 0.5))
  }

  // 6. Conjuntos con diferentes rangos
  test("Intersección de conjuntos con diferentes rangos") {
    val conjuntoE: objConjuntosDifusos.ConjDifuso = {
      case 10 => 0.6;
      case 20 => 0.8;
      case _ => 0.0
    }
    val interseccion = objConjuntosDifusos.interseccion(conjuntoA, conjuntoE)
    assert(interseccion(10) == 0.0)
    assert(interseccion(20) == 0.0)
    assert(interseccion(1) == 0.0)
    assert(interseccion(3) == 0.0)
  }

  // 7. Conjuntos con valores límite
  test("Intersección con valores límite") {
    val conjuntoF: objConjuntosDifusos.ConjDifuso = {
      case 0 => 0.1;
      case 1000 => 0.9;
      case _ => 0.0
    }
    val interseccion = objConjuntosDifusos.interseccion(conjuntoA, conjuntoF)
    assert(interseccion(0) == 0.0)
    assert(interseccion(1000) == 0.0)
    assert(interseccion(1) == 0.0)
  }
}
