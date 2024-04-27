package io

import domain.Candidate
import domain.Car

class MoveResult private constructor(private val snapshots: List<CarSnapshot>) {
    fun mapTo(): List<Candidate> {
        return snapshots.map { it.mapTo() }
    }

    fun getFormatted(): String {
        return buildString {
            snapshots.forEach {
                append(it.getFormatted())
            }
            append("\n")
        }
    }

    companion object {
        fun from(movedCar: List<Car>): MoveResult {
            return MoveResult(movedCar.map { CarSnapshot.from(it) })
        }
    }
}