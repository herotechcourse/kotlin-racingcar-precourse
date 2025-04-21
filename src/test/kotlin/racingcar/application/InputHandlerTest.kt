import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import racingcar.InputHandler

class InputHandlerTest : NsTest() {

    @Test
    fun `Returns a RaceInputs object if a valid car name and number of rounds are entered`() {
        assertSimpleTest {
            // given: 입력값 지정 (자동차 이름과 라운드 수)
            run("car1,car2,car3", "5")

            val inputHandler = InputHandler()
            val raceInputs = inputHandler.getInputs()

            // then: 예상한 결과 확인
            assertThat(raceInputs?.cars).containsExactly("car1", "car2", "car3")
            assertThat(raceInputs?.round).isEqualTo(5)
        }
    }

    @Test
    fun `Throws an exception if the car name is invalid`() {
        assertSimpleTest {
            // given: 잘못된 자동차 이름 (빈 문자열)
            run("", "3")

            val inputHandler = InputHandler()

            // then: 예외가 발생해야 함
            assertThrows<IllegalArgumentException> {
                inputHandler.getInputs()
            }
        }
    }

    @Test
    fun `Throws an exception if the number of rounds is not a number`() {
        assertSimpleTest {
            // given: 라운드 수에 숫자가 아닌 값 입력
            run("car1,car2", "five")

            val inputHandler = InputHandler()

            // then: 예외가 발생해야 함
            assertThrows<IllegalArgumentException> {
                inputHandler.getInputs()
            }
        }
    }

    override fun runMain() {
    }
}
