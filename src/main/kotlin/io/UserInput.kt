package io

import domain.Car
import domain.RaceMetaData

class UserInput private constructor(private val cars: List<Car>, private val moveCount: Int) {
    fun mapTo(): RaceMetaData {
        return RaceMetaData(cars, moveCount)
    }

    companion object {
        fun of(cars: List<Car>, moveCount: Int): UserInput {
            return UserInput(cars, moveCount)
        }
    }
}