abstract class Empleado (
    val nombre: String,
    val salarioBase: Double
){
    def salarioTotal: Double
}

class Desarrollador (nombre: String, salarioBase:Double) extends Empleado(nombre,salarioBase){
    val bonoFijo: Double = 200.0
    def salarioTotal: Double = salarioBase + bonoFijo
}

class Vendedor(nombre: String, salarioBase: Double, val ventas: Int) extends Empleado(nombre, salarioBase) {
    def salarioTotal: Double = salarioBase + (ventas*0.2)
}

class Gerente(nombre: String, salarioBase: Double) extends Empleado(nombre,salarioBase){
    val bonoPoercentual = salarioBase*0.4
    def salarioTotal: Double = salarioBase + bonoPoercentual
}

object Ejercicio3 {
    def main (args: Array[String]): Unit = {
        val desarrollador = new Desarrollador("Alan",2500)
        println(desarrollador.salarioTotal)
        val vendedor = new Vendedor("Walter", 3500, 1500)
        println(vendedor.salarioTotal)
        val gerente = new Gerente("Victor", 5000)
        println(gerente.salarioTotal)
    }
}