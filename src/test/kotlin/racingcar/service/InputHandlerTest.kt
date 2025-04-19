package racingcar.service

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.main

class InputHandlerTest : NsTest() {


    @Test
    fun `valid input should be accepted`() {
        assertSimpleTest {
            run("pobi,jun", "3")
            val result = output()
            assertThat(result).contains(
                "Enter the names of the cars (comma-separated):",
                "How many rounds will be played?"
            )
        }
    }

    @Test
    fun `throws when round input is not a positive integer`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,jun", "0")
            }
        }
    }

    @Test
    fun `throws when car name is too long`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,toolong", "3")
            }
        }
    }

    @Test
    fun `throws when car name is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,", "3")
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [".", "0", "-1", " ", ",", "a", "!"])
    fun `exceptions test of rounds validations`(roundVal: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaj", roundVal) }
        }
    }

    override fun runMain() {
        main()
    }
}