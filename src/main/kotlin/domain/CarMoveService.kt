package domain

class CarMoveService {

    fun moveCars(cars: List<Car>): List<Car> {
        cars.forEach {
            it.move(RandomNumberGenerator.nextValue())
        }
        return cars
    }
}