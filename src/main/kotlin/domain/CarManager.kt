package domain

class CarManager private constructor(private val cars: List<Car>) {

    companion object {
        fun from(names: List<String>): CarManager {
            return CarManager(names.stream()
                .map { Car(it) }
                .toList())
        }
    }

    fun race(decisionValues: DecisionValueGenerator, history: ProcessHistoryManager) {
        cars.map { car ->
            car.decide(decisionValues.generate())
            history.append(car)
            car
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
            .map { it.getName() }
    }
}