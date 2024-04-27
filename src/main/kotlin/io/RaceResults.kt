package io

import domain.Candidate
import domain.Car

class RaceResults private constructor(private val histories: MutableList<MoveResult>) {
    fun writeHistory(movedCars: List<Car>) {
        histories.add(MoveResult.from(movedCars))
    }

    fun getHistories(): String {
        return buildString {
            histories.forEach {
                append("\n")
                append(it.getFormatted())
            }
        }
    }

    fun mapTo(): List<Candidate> {
        val lastMoveResult = histories[histories.lastIndex]
        return lastMoveResult.mapTo()
    }

    companion object {
        fun newInstance(): RaceResults {
            return RaceResults(mutableListOf())
        }
    }

}
