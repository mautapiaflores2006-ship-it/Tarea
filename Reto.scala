abstract class Cuenta(
  val titular: String,
  val saldo: Double
) {
  def depositar(monto: Double): Cuenta
  def retirar(monto: Double): Cuenta
}

class CuentaAhorro(
  titular: String,
  saldo: Double,
  val tasaInteres: Double
) extends Cuenta(titular, saldo) {
  override def depositar(monto: Double): Cuenta = {
    new CuentaAhorro(titular, saldo + monto, tasaInteres)
  }

  override def retirar(monto: Double): Cuenta = {
    if (saldo >= monto) {
      new CuentaAhorro(titular, saldo - monto, tasaInteres)
    } else {
      this
    }
  }
}

class CuentaCorriente(
  titular: String,
  saldo: Double,
  val limiteSobregiro: Double
) extends Cuenta(titular, saldo) {
  override def depositar(monto: Double): Cuenta = {
    new CuentaCorriente(titular, saldo + monto, limiteSobregiro)
  }

  override def retirar(monto: Double): Cuenta = {
    if ((saldo + limiteSobregiro) >= monto) {
      new CuentaCorriente(titular, saldo - monto, limiteSobregiro)
    } else {
      this
    }
  }
}

object Reto {
  def main(args: Array[String]): Unit = {
    val cuenta1 = new CuentaAhorro("Ana", 1000.0, 0.05)
    val cuenta2 = cuenta1.depositar(500.0)

    println(s"Titular: ${cuenta1.titular} - Saldo: ${cuenta1.saldo}")
    println(s"Titular: ${cuenta2.titular} - Saldo: ${cuenta2.saldo}")

    val cuenta3 = cuenta2.retirar(200.0)
    println(s"Titular: ${cuenta3.titular} - Saldo: ${cuenta3.saldo}")
  }
}