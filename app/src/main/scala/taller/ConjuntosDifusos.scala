package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double
    def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
    }

  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
    (x: Int) => cd1(x) max cd2(x)
  }

  def grande(d: Int, e: Int): ConjDifuso = {
    def potencia(base: Double, exp: Int): Double = {
      if (exp == 0) 1.0
      else base * potencia(base, exp - 1)
    }

    (n: Int) => {
      if (n <= 0) 0.0
      else {
        val base = n.toDouble / (n + d).toDouble
        potencia(base, e)
      }
    }

  }










}

