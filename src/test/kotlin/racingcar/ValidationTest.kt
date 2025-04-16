package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationTest : NsTest() {
    @Test
    fun `car name validation test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("toolongname,pobi", "1")
            }
        }
    }

    @Test
    fun `round validation test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "-1")
            }
        }
    }

    override fun runMain() {
        main()
    }
}