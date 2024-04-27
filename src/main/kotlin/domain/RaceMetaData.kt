package domain

data class RaceMetaData(private val cars: List<Car>, private var moveCount: Int) {
    fun getCars(): List<Car> {
        return cars
    }

    fun getMoveCount(): Int {
        return moveCount
    }

}
