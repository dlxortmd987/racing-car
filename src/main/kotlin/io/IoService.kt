package io

import domain.Candidate
import domain.Car

class IoService {
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

    fun getMoveCount(): Int {
        return try {
            return io.getMoveCount()
        } catch (e: IllegalArgumentException) {
            io.showCountError()
            getMoveCount()
        }
    }

    fun showResult(results: RaceResults) {
        io.showMoves(results)
    }

    fun showWinners(winners: List<Candidate>) {
        io.showWinners(winners.map { it.getName() })
    }
}