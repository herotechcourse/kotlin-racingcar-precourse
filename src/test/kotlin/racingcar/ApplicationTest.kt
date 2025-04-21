package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `joint winners test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")

                assertThat(output()).contains("pobi : -", "woni : -", "Winners : pobi, woni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    @Test
    fun `every car stop test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")

                assertThat(output()).contains("pobi : ", "woni : ", "Winners : pobi, woni")
            },
            STOP,
            STOP
        )
    }

    @Test
    fun `car move availability test`() {
        val car = Car("testCar", canMove = { true })
        car.moveForward()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car move unavailability test`() {
        val car = Car("testCar", canMove = { false })
        car.moveForward()
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `valid round count test`() {
        val validInput = validateRoundInput("3")
        assertThat(validInput).isEqualTo(3)
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `null car name exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateCarNames(null)
        }
        assertThat(exception.message).isEqualTo("Car name cannot be empty.")
    }

    @Test
    fun `empty car name exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateCarNames(" ")
        }
        assertThat(exception.message).isEqualTo("Car name cannot be empty.")
    }

    @Test
    fun `partially empty car name exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateCarNames("aaa, ,bbb")
        }
        assertThat(exception.message).isEqualTo("Car name cannot be blank.")
    }

    @Test
    fun `car name over 5 characters exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateCarNames("aaa,morethan5character,ccc")
        }
        assertThat(exception.message).isEqualTo("Car names must be 5 characters or fewer.")
    }

    @Test
    fun `null round count exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateRoundInput(null)
        }
        assertThat(exception.message).isEqualTo("Number of rounds cannot be empty.")
    }

    @Test
    fun `empty round count exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateRoundInput(" ")
        }
        assertThat(exception.message).isEqualTo("Number of rounds cannot be empty.")
    }

    @Test
    fun `no int type for round count exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateRoundInput("one")
        }
        assertThat(exception.message).isEqualTo("Please enter a valid number.")
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
