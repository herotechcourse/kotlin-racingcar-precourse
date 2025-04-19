package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest : NsTest() {
    @Test
    fun `blank car names input test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(" ", "1")
            }
        }
    }

    @Test
    fun `blank car names with comma test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,", "1")
            }
        }
    }

    @Test
    fun `duplicated car names test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,pobi", "1")
            }
        }
    }

    @Test
    fun `non integer round number input test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "hi")
            }
        }
    }

    @Test
    fun `negative round number input test`() {
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