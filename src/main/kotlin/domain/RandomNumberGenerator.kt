package domain

import kotlin.random.Random

class RandomNumberGenerator {
    companion object {
        fun nextValue(): Int {
            return Random.nextInt(0, 10)
        }
    }
}