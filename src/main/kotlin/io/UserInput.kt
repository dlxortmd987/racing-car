package io

import domain.Car

class UserInput private constructor(cars: List<Car>, moveCount: Int) {
    companion object {
        fun of(cars: List<Car>, moveCount: Int): UserInput {
            return UserInput(cars, moveCount)
        }
    }
}