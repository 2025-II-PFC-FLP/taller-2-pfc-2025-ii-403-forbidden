package taller
import scala.annotation.tailrec

class ConjuntosDifusos {
  type ConjDifuso = Int => Double
    def pertenece(elem: Int, s: ConjDifuso): Double = {
    s(elem)
    }

    def grande(d: Int, e: Int): ConjDifuso = {

    }

    def complemento(c: ConjDifuso): ConjDifuso = {
      elem => {
        val grado = c(elem)
        val complemento = 1.0 - grado
        complemento
      }
    }

    def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {

    }

    def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {

    }
    
    def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
      @tailrec
      def aux(i: Int): Boolean = {
        if (i > 1000) true
        else if (cd1(i) > cd2(i)) false
        else aux(i + 1)
      }
      aux(0)
    }

    def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
        
    }
}

