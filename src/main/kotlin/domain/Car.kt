package domain

class Car private constructor(private val name: String, private var position: Int) {

    companion object {
        fun from(name: String): Car {
            if (name.length > 5) {
                throw IllegalArgumentException()
            }

            return Car(name, 0)
        }

        fun testInstance(name: String, position: Int): Car {
            return Car(name, position)
        }
    }

    override fun toString(): String {
        return "Car(name='$name', position=$position)"
    }

    fun move(value: Int) {
        if (value >= 4) {
            position += 1
        }
    }

    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return position
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }


}