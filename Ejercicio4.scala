trait Notificacion {
    def enviar(mensaje:String):String
}

class Email() extends Notificacion {
    def enviar(mensaje: String): String = s"Enviando correo: $mensaje"
}

class SMS() extends Notificacion {
    def enviar(mensaje: String): String = s"Enviando SMS: $mensaje"
}

class Push() extends Notificacion {
    def enviar(mensaje: String): String = s"Enviando notificacion: $mensaje"
}

def procesarNotificacion(notificacion: Notificacion,
        mensaje: String): String = notificacion.enviar(mensaje)

object  Ejercicio4 {
    def main (args:Array[String]): Unit = {
        val email = new Email()
        val sms = new SMS()
        val push = new Push()

        println(procesarNotificacion(email, "Hola"))
        println(procesarNotificacion(sms, "Que tal"))
        println(procesarNotificacion(push, "Hola"))
    }
}