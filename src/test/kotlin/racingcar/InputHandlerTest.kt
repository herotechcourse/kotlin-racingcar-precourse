package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class InputHandlerTest : NsTest() {

    @Test
    fun `Returns a RaceInputs object if a valid car name and number of rounds are entered`() {
        assertSimpleTest {
            run("car1,car2,car3", "5")

            val inputHandler = InputHandler()
            val raceInputs = inputHandler.getInputs()

            assertThat(raceInputs.cars).containsExactly("car1", "car2", "car3")
            assertThat(raceInputs.round).isEqualTo(5)
        }
    }

    @Test
    fun `Throws an exception if the car name is invalid`() {
        assertSimpleTest {
            run(" , , , ", "3")

            val inputHandler = InputHandler()

            assertThrows<IllegalArgumentException> {
                inputHandler.getInputs()
            }
        }
    }

    @Test
    fun `Throws an exception if the number of rounds is not a number`() {
        assertSimpleTest {
            run("car1,car2", "five")

            val inputHandler = InputHandler()

            assertThrows<IllegalArgumentException> {
                inputHandler.getInputs()
            }
        }
    }

    override fun runMain() {
    }
}
