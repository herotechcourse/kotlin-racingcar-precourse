package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun testInvalidCarNameTooLong() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,toolongname", "1")
            }
        }
    }

    @Test
    fun testInvalidRoundCountZero() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
        }
    }

    @Test
    fun testInvalidRoundCountNegative() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "-1")
            }
        }
    }

    @Test
    fun testInvalidRoundCountNonNumeric() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "abc")
            }
        }
    }

    // Car model tests
    @Test
    fun testCarCreationAndMovement() {
        val car = Car("test")
        assertThat(car.name).isEqualTo("test")
        assertThat(car.position).isZero()

        // Test car movement
        val initialPosition = car.position
        car.position++
        assertThat(car.position).isEqualTo(initialPosition + 1)
    }

    override fun runMain() {
        main()
    }
}