package racingcar.inputUtilsTest

import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class InputUtilsTest : NsTest() {
    @Test
    fun `read valid car names`() {
        assertSimpleTest {
            run("lisa,jim,tommy", "5")
            assertThat(output()).contains("lisa")
            assertThat(output()).contains("jim")
            assertThat(output()).contains("tommy")
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
            assertThat(output().split("lisa :").size - 1).isEqualTo(5)
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
