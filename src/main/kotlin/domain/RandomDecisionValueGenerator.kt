package domain

import kotlin.random.Random

class RandomDecisionValueGenerator : DecisionValueGenerator {

    override fun generate(): Int {
        return Random.nextInt(10)
    }

}