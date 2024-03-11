package domain

class RaceRunner(private val carManager: CarManager) {

    fun run(
        tryNumber: Int,
        decisionValueGenerator: DecisionValueGenerator,
        processHistoryManager: ProcessHistoryManager
    ) {
        for (i in 1.. tryNumber) {
            carManager.race(decisionValueGenerator, processHistoryManager)
            processHistoryManager.appendLineBreak()
        }
    }
}
