package taller

import scala.annotation.tailrec

class ConjuntosDifusos {
  type ConjDifuso = Int => Double

  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
      (x: Int) => {
        val grado1 = cd1(x)
        val grado2 = cd2(x)
        if (grado1 < grado2) grado1 else grado2
      }
  }

  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso ): Boolean = {
      @tailrec
      def auxiliar(n: Int): Boolean = {
        if (n > 1000) true
        else if (cd1(n) == cd2(n)) auxiliar(n + 1)
        else false
      }
      auxiliar(0)
  }
}

