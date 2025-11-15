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

interface MedicationState {
    fun take()
    fun skip()
}
class Medication(var name: String) {
    var state: MedicationState = PendingState(this)

    fun take() = state.take()
    fun skip() = state.skip()
}

class PendingState(private val med: Medication) : MedicationState {
    override fun take() {
        println("${med.name}: marcado como tomado")
        med.state = TakenState(med)
    }

    override fun skip() {
        println("${med.name}: marcado como omitido ⚠")
        med.state = SkippedState(med)
    }
}

class TakenState(private val med: Medication) : MedicationState {
    override fun take() {
        println("${med.name}: ya fue tomado")
    }

    override fun skip() {
        println("${med.name}: no se puede omitir, ya fue tomado")
    }
}

class SkippedState(private val med: Medication) : MedicationState {
    override fun take() {
        println("${med.name}: cambiado a tomado (recuperado)")
        med.state = TakenState(med)
    }

    override fun skip() {
        println("${med.name}: ya fue omitido")
    }
}




fun main() {
   println("=== PATRONDE DISEÑO ===\n")

    println("PATRÓN SINGLETON")
    ReminderManager.addReminder("Tomar Paracetamol a las 8:00")
    ReminderManager.addReminder("Tomar Ibuprofeno a las 14:00")
    ReminderManager.showReminders()
    
    println("\n PATRÓN STATE")
    val med = Medication("Paracetamol")
    med.take()
    med.skip()
    println("--- Reiniciando otro medicamento ---")
    val med2 = Medication("Ibuprofeno")
    med2.skip()
    med2.take()


}