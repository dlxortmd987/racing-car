package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.types.shouldBeTypeOf

internal class CarTest : BehaviorSpec({

    Given("from") {

        When("5자 이하의 문자열이 주어졌을 때,") {
            val name = "name1"
            val actual = Car.from(name)
            Then("자동차가 반환된다.") {
                actual.shouldBeTypeOf<Car>()
            }
        }

        When("5자 이상의 문자열이 주어졌을 때,") {
            val name = "name11"
            Then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> { Car.from(name) }
            }
        }
    }
})