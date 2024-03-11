package domain


private const val DICISION_CRITERIA = 4

class Car(private val name: String, private var position: Int) {

    constructor(name: String) : this(name, 0)

    fun decide(decisionNumber: Int) {
        if (decisionNumber >= DICISION_CRITERIA) {
            position++
        }
    }

    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return position
    }


}