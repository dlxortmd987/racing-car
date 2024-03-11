package domain

class Application(names: List<String>, private val tryNumber: Int, private val processHistoryManager: ProcessHistoryManager) {

    private val decisionValueGenerator: DecisionValueGenerator = RandomDecisionValueGenerator()
    private val carManager = CarManager.from(names)
    private val raceRunner = RaceRunner(carManager)

    fun process(): List<String> {
        raceRunner.run(tryNumber, decisionValueGenerator, processHistoryManager)

        return carManager.getWinners()
    }
}