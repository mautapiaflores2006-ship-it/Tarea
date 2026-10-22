//ejercicio 1
class Caja[A](val contenido: A) {
  def obtener: A = contenido

  def combinar[B](otro: B): (A, B) =
    (contenido, otro)
}

//ejercicio 2
def seleccionarPrimero[A](primero: A, segundo: A): A =
  primero

//ejercicio 3
def transformar[A, B](valor: A, funcion: A => B): B =
  funcion(valor)

//ejercicio 4
abstract class Vehiculo(val marca: String)

class Automovil(marca: String) extends Vehiculo(marca)

class Motocicleta(marca: String) extends Vehiculo(marca)

class RegistroVehiculo[A <: Vehiculo](val vehiculo: A)

//ejercicio 5
class Animal(val nombre: String)

class Perro(nombre: String) extends Animal(nombre)

class Gato(nombre: String) extends Animal(nombre)

class Contenedor[+A](val valor: A)

//ejercicio 6
trait Procesador[-A] {
  def procesar(valor: A): String
}

class ProcesadorAnimal extends Procesador[Animal] {
  def procesar(valor: Animal): String =
    s"Procesando ${valor.nombre}"
}

//ejercicio 7
trait Productor[+A] {
  def producir: A
}

trait Consumidor[-A] {
  def consumir(valor: A): String
}

class CriadorPerros extends Productor[Perro] {
  def producir: Perro = new Perro("Rocky")
}

class CriadorGatos extends Productor[Gato] {
  def producir: Gato = new Gato("Michi")
}

class ConsumidorAnimales extends Consumidor[Animal] {
  def consumir(valor: Animal): String =
    s"Consumido: ${valor.nombre}"
}

//ejercicio 8
class Resultado[A](
  val valor: A,
  val exitoso: Boolean,
  val mensaje: String
)

class Persona(val nombre: String)

object Tarea22Oct {
  def main(args: Array[String]): Unit = {

    // 1
    val cajaInt = new Caja[Int](10)
    val cajaString = new Caja[String]("Scala")
    val cajaBoolean = new Caja[Boolean](true)

    println(cajaInt.obtener)
    println(cajaString.obtener)
    println(cajaBoolean.obtener)
    println(cajaInt.combinar("Hola"))
    println(cajaString.combinar(2026))
    println(cajaBoolean.combinar(5.5))

    // 2
    println(seleccionarPrimero(10, 20))
    println(seleccionarPrimero("Scala", "Java"))
    println(seleccionarPrimero(3.14, 2.71))

    // 3
    println(transformar(10, (numero: Int) => numero.toString))
    println(transformar("Scala", (texto: String) => texto.length))
    println(transformar(3.5, (numero: Double) => numero > 0))

    // 4
    val registroAuto = new RegistroVehiculo(new Automovil("Toyota"))
    val registroMoto = new RegistroVehiculo(new Motocicleta("Honda"))

    println(registroAuto.vehiculo.marca)
    println(registroMoto.vehiculo.marca)

    // 5
    val contenedorPerro: Contenedor[Perro] =
      new Contenedor(new Perro("Rocky"))

    val contenedorAnimal: Contenedor[Animal] =
      contenedorPerro

    println(contenedorAnimal.valor.nombre)

    // 6
    val procesadorAnimal: Procesador[Animal] =
      new ProcesadorAnimal

    val procesadorPerro: Procesador[Perro] =
      procesadorAnimal

    println(procesadorPerro.procesar(new Perro("Rocky")))

    // 7
    val productorPerro: Productor[Perro] =
      new CriadorPerros

    val productorGato: Productor[Gato] =
      new CriadorGatos

    val productorAnimal: Productor[Animal] =
      productorPerro

    val consumidorAnimal: Consumidor[Animal] =
      new ConsumidorAnimales

    val consumidorPerro: Consumidor[Perro] =
      consumidorAnimal

    val consumidorGato: Consumidor[Gato] =
      consumidorAnimal

    println(productorAnimal.producir.nombre)
    println(productorGato.producir.nombre)
    println(consumidorPerro.consumir(new Perro("Rocky")))
    println(consumidorGato.consumir(new Gato("Michi")))

    // 8
    val resultadoInt = new Resultado[Int](100, true, "Operación completada")
    val resultadoString =
      new Resultado[String]("Correcto", true, "Texto procesado")
    val resultadoPersona =
      new Resultado[Persona](new Persona("Carlos"), true, "Persona registrada")

    println(resultadoInt.valor)
    println(resultadoInt.exitoso)
    println(resultadoInt.mensaje)

    println(resultadoString.valor)
    println(resultadoString.exitoso)
    println(resultadoString.mensaje)

    println(resultadoPersona.valor.nombre)
    println(resultadoPersona.exitoso)
    println(resultadoPersona.mensaje)
  }
}