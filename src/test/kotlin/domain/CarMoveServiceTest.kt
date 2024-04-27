package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject

internal class CarMoveServiceTest : BehaviorSpec({
    val stub = CarMoveService()

    Given("moveCars") {
        mockkObject(RandomNumberGenerator)
        every { RandomNumberGenerator.nextValue() } returnsMany listOf(1, 5, 3)
        val cars = listOf(Car.from("test1"), Car.from("test2"), Car.from("test3"))
        val expect = listOf(
            Car.testInstance("test1", 0),
            Car.testInstance("test2", 1),
            Car.testInstance("test3", 0)
        )
        When("자동차들이 주어졌을 때") {
            val actual = stub.moveCars(cars)
            Then("차들의 위치를 움직일 수 있다.") {
                actual shouldBe expect
            }
        }
    }
})