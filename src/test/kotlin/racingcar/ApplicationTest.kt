package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `throws exception when car name is too long`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,toolongname", "3")
            }
        }
    }

    @Test
    fun `throws exception when car name is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,", "3")
            }
        }
    }

    @Test
    fun `throws exception when duplicate car names exist`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,pobi", "3")
            }
        }
    }

    @Test
    fun `throws exception when round count is not a number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "abc")
            }
        }
    }

    @Test
    fun `throws exception when round count is zero or negative`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
        }
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
