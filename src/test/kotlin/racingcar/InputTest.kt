package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest : NsTest() {

    @Test
    fun `should throw exception when name is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("") }
        }
    }

    @Test
    fun `should throw exception when name without comma separator is entered`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi") }
        }
    }

    @Test
    fun `should throw exception when car name is too long`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji") }
        }
    }

    @Test
    fun `should throw exception when rounds is 0`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { 
                runException("0") 
            }
        }
    }

    @Test
    fun `should throw exception when rounds is negative`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { 
                runException("-1") 
            }
        }
    }

    override fun runMain() {
        main()
    }
}