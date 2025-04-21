package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.input.InputReader
import java.io.ByteArrayInputStream

class InputTest : NsTest() {

    @Test
    fun `empty input throw exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(" ", "1")
            }
        }
    }

    @Test
    fun `name more than 5 characters throw exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("bobibobi,woni", "1")
            }
        }
    }

    @Test
    fun `empty name throw exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("  ,woni", "1")
            }
        }
    }

    @Test
    fun `empty number rounds throw exception`() {
        // given
        val input = "pobi,woni\n\n" // 자동차 이름 입력 후 라운드에서 엔터만 입력
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // when & then
        assertThrows<IllegalArgumentException> {
            InputReader.readNumberOfRounds("How many rounds?")
        }
    }

    @Test
    fun `invalid type of number rounds throw exception`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("bobi,woni", "asd")
            }
        }
    }

    override fun runMain() {
        main()
    }
}