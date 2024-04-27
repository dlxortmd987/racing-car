package domain

class Candidate private constructor(private val name: String, private val position: Int) {
    fun getPosition(): Int {
        return position
    }

    fun getName(): String {
        return name
    }

    companion object {

        fun of(name: String, position: Int): Candidate {
            return Candidate(name, position)
        }

        fun findWinners(candidates: List<Candidate>): List<Candidate> {
            val maxPosition = candidates.maxOf { it.getPosition() }
            return candidates.filter { it.isSamePosition(maxPosition) }
        }
    }

    private fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

}
