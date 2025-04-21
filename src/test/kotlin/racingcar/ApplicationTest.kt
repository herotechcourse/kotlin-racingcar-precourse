package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {

    // Test: User presses enter without typing any car names
    @Test
    fun `should throw if car name input is blank`() {
        assertSimpleTest {
            assertThatThrownBy { runException("", "3") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Please enter at least one car name")
        }
    }

    // Test: User types car names without commas (e.g., "pobiwoni")
    @Test
    fun `should throw if names are not comma separated`() {
        assertSimpleTest {
            assertThatThrownBy { runException("pobiwoni", "3") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("You must separate car names with commas")
        }
    }

    // Test: User enters a blank name between commas (e.g., "pobi,,woni")
    @Test
    fun `should throw if name is blank between commas`() {
        assertSimpleTest {
            assertThatThrownBy { runException("pobi,,woni", "3") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names must not be blank")
        }
    }

    // Test: User starts the input with a comma (e.g., ",pobi,woni")
    @Test
    fun `should throw if input starts with comma`() {
        assertSimpleTest {
            assertThatThrownBy { runException(",pobi,woni", "3") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names must not be blank")
        }
    }

    // Test: User ends the input with a comma (e.g., "pobi,woni,")
    @Test
    fun `should throw if input ends with comma`() {
        assertSimpleTest {
            assertThatThrownBy { runException("pobi,woni,", "3") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names must not be blank")
        }
    }

    // Test: User enters a name longer than 5 characters (e.g., "123456")
    @Test
    fun `should throw if a name exceeds 5 characters`() {
        assertSimpleTest {
            assertThatThrownBy { runException("pobi,123456", "3") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Each car name must be 1 to 5 characters long")
        }
    }

    // Test: User types non-numeric text for the number of rounds (e.g., "abc")
    @Test
    fun `should throw if round input is not a number`() {
        assertSimpleTest {
            assertThatThrownBy { runException("pobi,woni", "abc") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Please enter a valid number")
        }
    }

    // Test: User types zero as the number of rounds (not allowed)
    @Test
    fun `should throw if round input is zero`() {
        assertSimpleTest {
            assertThatThrownBy { runException("pobi,woni", "0") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Number of rounds must be positive")
        }
    }

    override fun runMain() {
        main()
    }
}


// Provided code
//package racingcar
//
//import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
//import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
//import camp.nextstep.edu.missionutils.test.NsTest
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.assertThrows
//
//class ApplicationTest : NsTest() {
//    @Test
//    fun `feature test`() {
//        assertRandomNumberInRangeTest(
//            {
//                run("pobi,woni", "1")
//                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
//            },
//            MOVING_FORWARD,
//            STOP,
//        )
//    }
//
//    @Test
//    fun `exception test`() {
//        assertSimpleTest {
//            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
//        }
//    }
//
//    override fun runMain() {
//        main()
//    }
//
//    companion object {
//        private const val MOVING_FORWARD: Int = 4
//        private const val STOP: Int = 3
//    }
//}
