package io

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic

private const val CONSOLE = "kotlin.io.ConsoleKt"

internal class IoModuleTest : BehaviorSpec({
    val stub = IoModule()

    afterTest { unmockkStatic(CONSOLE) }

    Given("getCarNames") {

        When("이름들이 쉼표를 구분자로 주어졌을 때") {
            mockkStatic(CONSOLE)
            every { readLine() } returns "name1,name2,name3"
            val actual = stub.getCarNames()
            val expect = listOf("name1", "name2", "name3")
            Then("이름들이 반환된다.") {
                actual shouldBe expect
            }
        }

        When("이름들이 빈 값일 때") {
            mockkStatic(CONSOLE)
            every { readLine() } returns ""
            Then("IllegalException 이 throw 된다.") {
                shouldThrow<IllegalArgumentException> { stub.getCarNames() }
            }
        }

        When("이름들이 null일 때") {
            mockkStatic(CONSOLE)
            every { readLine() } returns null
            Then("IllegalException 이 throw 된다.") {
                shouldThrow<IllegalArgumentException> { stub.getCarNames() }
            }
        }
    }

})