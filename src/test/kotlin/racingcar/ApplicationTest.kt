package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            assertThat(exception.message).isEqualTo("Car name cannot exceed 5 characters.")
        }
    }

    @Test
    fun `car name validation`() {
        assertThatThrownBy { Car("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name cannot be empty.")
    }

    @Test
    fun `car name length validation`() {
        assertThatThrownBy { Car("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name cannot exceed 5 characters.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni,jun", "pobi,woni", "pobi"])
    fun `create cars with valid names`(input: String) {
        val cars = createCars(input)
        assertThat(cars).hasSize(input.split(",").size)
    }

    @Test
    fun `create cars with empty names`() {
        assertThatThrownBy { createCars("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car names cannot be empty.")
    }

    @Test
    fun `create cars with duplicate names`() {
        assertThatThrownBy { createCars("pobi,pobi") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car names cannot be duplicated.")
    }

    @Test
    fun `validate rounds with valid input`() {
        assertThat(readRounds("5")).isEqualTo(5)
    }

    @Test
    fun `validate rounds with empty input`() {
        assertThatThrownBy { readRounds("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round number cannot be empty.")
    }

    @Test
    fun `validate rounds with non-numeric input`() {
        assertThatThrownBy { readRounds("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round number must be a positive integer.")
    }

    @Test
    fun `validate rounds with zero or negative input`() {
        assertThatThrownBy { readRounds("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round number must be greater than 0.")
    }

    @Test
    fun `find winners with single winner`() {
        val cars = listOf(
            Car("pobi").apply { repeat(3) { move() } },
            Car("woni").apply { repeat(2) { move() } },
            Car("jun").apply { repeat(1) { move() } }
        )
        val winners = findWinners(cars, 3)
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `find winners with multiple winners`() {
        val cars = listOf(
            Car("pobi").apply { repeat(3) { move() } },
            Car("woni").apply { repeat(2) { move() } },
            Car("jun").apply { repeat(3) { move() } }
        )
        val winners = findWinners(cars, 3)
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun")
    }

    override fun runMain() {
       Application.main(arrayOf())
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
