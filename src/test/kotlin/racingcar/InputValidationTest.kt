package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest : NsTest() {
    @Test
    fun `empty car's name prompt test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `car's names prompt separated by ' ' test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("car1 car2", "1") }
        }
    }

    @Test
    fun `car's name length longer then 5 test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("car123 car2", "1") }
        }
    }

    override fun runMain() {
        main()
    }
}