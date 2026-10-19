abstract class Animales(
    val nombre: String
) {
    def sonido(): String
}

trait Volador {
    def volar(): String
}

trait Nadador {
    def nadar(): String
}

class Perro02(nombre: String) extends Animales(nombre) {
    override def sonido(): String = "WOF WOF"
}

class Pato(nombre: String) extends Animales(nombre) with Volador with Nadador {
    override def sonido(): String = "CUAK CUAK"
    override def volar(): String = "Soy un pato volador"
    override def nadar(): String = "Soy un pato y estoy nadando"
}

class Pez(nombre: String) extends Animales(nombre) with Nadador {
    override def sonido(): String = "GLUP GLUP"
    override def nadar(): String = "Soy un pez y estoy nadando"
}

object Ejercicio2 {
    def main(args: Array[String]): Unit = {
        val pecesito = new Pez("Kadir")
        println(pecesito.sonido())
        println(pecesito.nadar())
    }
}
