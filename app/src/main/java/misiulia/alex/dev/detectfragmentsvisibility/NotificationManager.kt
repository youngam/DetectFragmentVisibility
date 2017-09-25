package misiulia.alex.dev.detectfragmentsvisibility

object NotificationManager {
    private lateinit var subscriber:Subscriber

   fun subscribe(subscriber: Subscriber) {
       this.subscriber = subscriber
   }

   fun next(newName: String) {
       subscriber.onNotification(newName)
   }

}