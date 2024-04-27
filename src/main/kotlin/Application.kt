import domain.Car
import io.IoModule
import io.UserInput

class Application {
    private val io = IoModule()

    fun getCars(): List<Car> {
        return try {
            val names = io.getCarNames()

            names.stream()
                .map { Car.from(it) }
                .toList()
        } catch (e: IllegalArgumentException) {
            io.showNameError()
            getCars()
        }
    }

    private fun getMoveCount(): Int {
        return try {
            return io.getMoveCount()
        } catch (e: IllegalArgumentException) {
            io.showCountError()
            getMoveCount()
        }
    }

    fun getUserInput(): UserInput {
        val cars = getCars()

        val moveCount = getMoveCount()

        return UserInput.of(cars, moveCount)
    }
}