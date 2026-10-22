abstract class Vehiculo(
  val marca: String,
  val velocidadMaxima: Double
) {
  def descripcion(): String
}

trait Electrico {
  def modoElectrico(): String = "Funcionando con motor eléctrico"
}

trait Recargable {
  def recargar(): String = "Recargando batería"
}

class Automovil(
  marca: String,
  velocidadMaxima: Double,
  val puertas: Int
) extends Vehiculo(marca, velocidadMaxima) {
  override def descripcion(): String = s"$marca, velocidad máxima: $velocidadMaxima km/h, puertas: $puertas"
}

class Motocicleta(
  marca: String,
  velocidadMaxima: Double
) extends Vehiculo(marca, velocidadMaxima) {
  override def descripcion(): String = s"$marca, velocidad máxima: $velocidadMaxima km/h"
}

class AutoElectrico(
  marca: String,
  velocidadMaxima: Double,
  val puertas: Int
) extends Vehiculo(marca, velocidadMaxima) with Electrico with Recargable {
  override def descripcion(): String = s"Auto Eléctrico $marca, velocidad máxima: $velocidadMaxima km/h, puertas: $puertas"
}

object MainVehiculos {
  def main(args: Array[String]): Unit = {
    val auto = new Automovil("Toyota", 180.0, 4)
    val moto = new Motocicleta("Yamaha", 150.0)
    val autoElectrico = new AutoElectrico("Tesla", 200.0, 4)

    println(auto.descripcion())
    println(moto.descripcion())
    println(autoElectrico.descripcion())
    println(autoElectrico.modoElectrico())
    println(autoElectrico.recargar())
  }
}