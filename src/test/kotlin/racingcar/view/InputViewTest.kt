package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest : NsTest() {
    @Test
    fun `read car names should return list of names`() {
        assertSimpleTest {
            run("pobi,woni,jun")
            val names = InputView.readCarNames()
            assertThat(names).containsExactly("pobi", "woni", "jun")
        }
    }

    @Test
    fun `read car names should trim whitespace`() {
        assertSimpleTest {
            run("pobi, woni , jun")
            val names = InputView.readCarNames()
            assertThat(names).containsExactly("pobi", "woni", "jun")
        }
    }

    @Test
    fun `read round count should return number`() {
        assertSimpleTest {
            run("5")
            val count = InputView.readRoundCount()
            assertThat(count).isEqualTo(5)
        }
    }

    @Test
    fun `read round count should throw exception for invalid input`() {
        assertSimpleTest {
            run("abc")
            assertThrows<IllegalArgumentException> {
                InputView.readRoundCount()
            }
        }
    }

    override fun runMain() {
        // Not needed for these tests
    }
} 