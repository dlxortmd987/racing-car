package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class CarTest : BehaviorSpec({

    val sut = Car("test")

    given("car") {
        `when`("4 미만의 숫자를 넣으면") {
            val originPosition = sut.getPosition()
            sut.decide(3)
            then("position이 바뀌지 않는다.") {
                sut.getPosition() shouldBe originPosition
            }
        }

        `when`("4 이상의 숫자를 넣으면") {
            val originPosition = sut.getPosition()
            sut.decide(5)
            then("position이 바뀐다.") {
                sut.getPosition() shouldNotBe originPosition
            }
        }
    }

}) {

}