// Ejercicio 1
case class Producto(
  nombre: String,
  precio: Double,
  stock: Int
)

def clasificar(producto: Producto): String =
  producto match
    case Producto(_, _, 0) =>
      "Sin stock"

    case Producto(_, precio, _) if precio >= 1000 =>
      "Producto premium"

    case _ =>
      "Producto estándar"

// Ejercicio 2
def posicion(punto: (Int, Int)): String =
  punto match
    case (0, 0) =>
      "Origen"

    case (0, y) =>
      s"Eje Y: $y"

    case (x, 0) =>
      s"Eje X: $x"

    case (x, y) =>
      s"Otro punto: ($x, $y)"

// Ejercicio 3
case class Estudiante(
  nombre: String,
  nota: Double
)

def resultado(estudiante: Estudiante): String =
  estudiante match
    case Estudiante(_, nota) if nota >= 90 =>
      "Excelente"

    case Estudiante(_, nota) if nota >= 70 =>
      "Aprobado"

    case Estudiante(_, nota) if nota >= 51 =>
      "Regular"

    case _ =>
      "Reprobado"

// Ejercicio 4
case class Inventario(
  producto: String,
  cantidad: Int
)

def agregar(inventario: Inventario, cantidad: Int): Inventario =
  inventario.copy(
    cantidad = inventario.cantidad + cantidad
  )

// Ejercicio 5
case class Direccion(
  ciudad: String,
  pais: String
)

case class Cliente(
  nombre: String,
  direccion: Direccion
)

def ubicacion(cliente: Cliente): String =
  cliente match
    case Cliente(_, Direccion(_, "Bolivia")) =>
      "Cliente boliviano"

    case _ =>
      "Cliente extranjero"

object Tarea22Oct {
  def main(args: Array[String]): Unit = {

    // 1
    println(clasificar(Producto("Teclado", 250.0, 10)))
    println(clasificar(Producto("Laptop", 2500.0, 5)))
    println(clasificar(Producto("Mouse", 120.0, 0)))

    // 2
    println(posicion((0, 0)))
    println(posicion((0, 5)))
    println(posicion((4, 0)))
    println(posicion((3, 7)))

    // 3
    println(resultado(Estudiante("Ana", 95)))
    println(resultado(Estudiante("Carlos", 80)))
    println(resultado(Estudiante("Luis", 60)))
    println(resultado(Estudiante("Pedro", 40)))

    // 4
    val inventario1 = Inventario("Teclado", 10)
    val inventario2 = agregar(inventario1, 5)

    println(inventario1)
    println(inventario2)

    // 5
    val clienteBoliviano =
      Cliente("Ana", Direccion("La Paz", "Bolivia"))

    val clienteExtranjero =
      Cliente("Carlos", Direccion("Lima", "Perú"))

    println(ubicacion(clienteBoliviano))
    println(ubicacion(clienteExtranjero))
  }
}