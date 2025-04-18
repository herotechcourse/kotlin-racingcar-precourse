package racingcar.inputUtilsTest

import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class InputUtilsTest : NsTest() {
    // This test verifies that valid car names are parsed correctly by checking console output
    // Note: It will become obsolete as printing the carNames list to the console is not required
    @Test
    fun `read valid car names`() {
        assertSimpleTest {
            run("lisa,jim,tommy", "5")
            assertThat(output()).contains("carNames: [lisa, jim, tommy]")
        }
    }

    @Test
    fun `throw exception when input is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("")
            }
        }
    }

    @Test
    fun `throw exception when car name is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("lisa,,tommy")
            }
        }
    }

    @Test
    fun `throw exception when car name is only non-printable characters`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("lisa, \t ,tommy")
            }
        }
    }

    @Test
    fun `throw exception when car name exceeds 5 characters`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("lisa,timothy,tommy")
            }
        }
    }

    @Test
    fun `read valid number of rounds`() {
        assertSimpleTest {
            run("lisa,jim,tommy", "5")
            assertThat(output()).contains("rounds: 5")
        }
    }

    @Test
    fun `throw exception when rounds input is empty`() {
        assertThrows<IllegalArgumentException> {
            runException("lisa,jim,tommy", "")
        }
    }

    @Test
    fun `throw exception when rounds input is not a number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("lisa,jim,tommy", "abc")
            }
        }
    }

    @Test
    fun `throw exception when rounds input is negative`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("lisa,jim,tommy", "-5")
            }
        }
    }

    @Test
    fun `throw exception when rounds input is zero`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("lisa,jim,tommy", "0")
            }
        }
    }

    override fun runMain() {
        racingcar.main()
    }
}
