//ej 3
trait Transporte{
    def costo(distancia: Double): Double  // en metros
}

class Taxi extends Transporte {
    def costo (distancia: Double): Double = (distancia/500) * 5 
}

class Bus extends Transporte {
def costo(distancia: Double): Double = {
    if distancia > 3000 then 3.50 else 3.0
    }
}

def calcularViaje(transporte: Transporte, distancia: Double): Double = {
    transporte.costo(distancia)
}

//ej 5
trait Notificacion {
  def destinatario: String
  def mensaje: String
  def enviar(): String
}

class Email(val destinatario: String, val mensaje: String) extends Notificacion {
  def enviar(): String =
    s"Email a $destinatario: $mensaje"
}

class SMS(val destinatario: String, val mensaje: String) extends Notificacion {
  def enviar(): String =
    s"SMS a $destinatario: $mensaje"
}

class NotificacionPush(val destinatario: String, val mensaje: String) extends Notificacion {
  def enviar(): String =
    s"Push a $destinatario: $mensaje"
}

def procesarNotificacion(n: Notificacion): String = {
  n.enviar()
}


object  Tarea21Oct {
    def main(args: Array[String]): Unit = {
        //3
        val taxi = new Taxi
        val bus = new Bus
        
        println(calcularViaje(taxi, 2000)) 
        println(calcularViaje(bus,  2000))  
        println(calcularViaje(bus,  5000)) 

        //5
        val email = new Email("kadir@gmail.com", "Hola Ana")
        val sms   = new SMS("+59139837567", "Tu código es 1234")
        val push  = new NotificacionPush("usuario42", "Tienes un nuevo mensaje")

        println(procesarNotificacion(email))
        println(procesarNotificacion(sms))
        println(procesarNotificacion(push))
    }
}