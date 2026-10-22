//ejercicio 1

trait Figura {
    def area: Double
    def mostrarArea(figura:Figura): Double = area
}

class Rectangulo(
    val base:Double,
    val altura: Double
) extends Figura {
    def area: Double = base * altura
}

class Circulo(
    val radio: Double
) extends Figura {
    def area: Double = Math.PI * radio * radio
}

class Triangulo(
    base: Double,
    altura:Double
) extends Figura {
    def area: Double = (base*altura)/2
}

object Ejercicio1 {
    def main(args:Array[String]): Unit = {
        val rectangulo = new Rectangulo(4,7)
        println(rectangulo.mostrarArea(rectangulo))
        val circulo = new Circulo(7)
        println(circulo.mostrarArea(circulo))
        val triangulo = new Triangulo(4,7)
        println(triangulo.mostrarArea(triangulo))
    }
}