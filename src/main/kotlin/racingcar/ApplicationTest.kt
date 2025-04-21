package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }

    @Test
    fun `testCarMovementAndStopping`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `testNameLengthValidation`() {
        assertSimpleTest {
            assertThatThrownBy { run("pobi,javaji", "1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car name cannot exceed 5 characters.")
        }
    }

    @Test
    fun `testDuplicateNameValidation`() {
        assertSimpleTest {
            assertThatThrownBy { run("pobi,pobi", "1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names cannot be duplicated.")
        }
    }

    @Test
    fun `testBlankNameValidation`() {
        assertSimpleTest {
            assertThatThrownBy { run("pobi,,jun", "1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names cannot be blank or empty.")
        }
    }

    @Test
    fun `testEmptyNameInputValidation`() {
        assertSimpleTest {
            assertThatThrownBy { run("", "1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Car names cannot be blank or empty.")
        }
    }

    @Test
    fun `testTryCountNotANumberValidation`() {
        assertSimpleTest {
            assertThatThrownBy { run("pobi,woni", "a") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("The number of rounds must be a number.")
        }
    }

    @Test
    fun `testTryCountZeroOrLessValidation`() {
        assertSimpleTest {
            assertThatThrownBy { run("pobi,woni", "0") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("The number of rounds must be greater than 0.")
        }
    }

    @Test
    fun `testTryCountNegativeValidation`() {
        assertSimpleTest {
            assertThatThrownBy { run("pobi,woni", "-1") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("The number of rounds must be greater than 0.")
        }
    }


    @Test
    fun `testSingleWinnerOutput`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains("Winners : pobi")
            },
            MOVING_FORWARD, STOP, STOP,
            MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `testMultipleWinnersOutput`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains("Winners : pobi, jun")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }


    @Test
    fun `testCarCreationWithLongNameThrowsException`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("longname")
        }
        assertThat(exception.message).contains("Car name cannot exceed 5 characters.")
    }

    @Test
    fun `testCarCreationWithBlankNameThrowsException`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car(" ")
        }
        assertThat(exception.message).contains("Car name cannot be blank.")
    }

    @Test
    fun `testCarCreationWithEmptyNameThrowsException`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("")
        }
        assertThat(exception.message).contains("Car name cannot be blank.")
    }


    @Test
    fun `testSuccessfulCarCreation`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `testCarMovementForward`() {
        val car = Car("test")
        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.position).isEqualTo(1)
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `testCarMovementStop`() {
        val car = Car("test")
        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.position).isEqualTo(0)
            },
            STOP
        )
    }

    @Test
    fun `testPositionStringRepresentation`() {
        val car = Car("test", 3)
        assertThat(car.getPositionString()).isEqualTo("---")
    }

    @Test
    fun `testCarToStringOutput`() {
        val car = Car("test", 2)
        assertThat(car.toString()).isEqualTo("test : --")
    }

    override fun runMain() {
        main()
    }
}
