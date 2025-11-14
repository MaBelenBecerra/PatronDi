object ReminderManager {
    private val reminders = mutableListOf<String>()

    fun addReminder(reminder: String) {
        reminders.add(reminder)
        println("Recordatorio agregado: $reminder")
    }

    fun showReminders() {
        println("Lista de recordatorios:")
        reminders.forEach { println("- $it") }
    }
}


fun main() {
   println("=== PATRONDE DISEÑO ===\n")

    println("PATRÓN SINGLETON")
    ReminderManager.addReminder("Tomar Paracetamol a las 8:00")
    ReminderManager.addReminder("Tomar Ibuprofeno a las 14:00")
    ReminderManager.showReminders()

}