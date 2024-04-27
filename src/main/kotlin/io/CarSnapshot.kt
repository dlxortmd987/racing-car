package io

import domain.Candidate
import domain.Car

class CarSnapshot private constructor(private val name: String, private val position: Int) {
    fun mapTo(): Candidate {
        return Candidate.of(name, position)
    }

    fun getFormatted(): String {
        val progress = buildString {
            repeat(position) {
                append("-")
            }
        }

        return "$name : $progress\n"
    }

    companion object {
        fun from(car: Car): CarSnapshot {
            return CarSnapshot(car.getName(), car.getPosition())
        }
    }

}
