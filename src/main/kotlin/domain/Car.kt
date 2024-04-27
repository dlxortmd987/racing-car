package domain

class Car private constructor(private val name: String, private val position: Int) {

    companion object {
        fun from(name: String): Car {
            if (name.length > 5) {
                throw IllegalArgumentException()
            }

            return Car(name, 0)
        }
    }

    override fun toString(): String {
        return "Car(name='$name', position=$position)"
    }
}