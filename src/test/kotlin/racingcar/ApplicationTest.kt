package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

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
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }
    @ParameterizedTest
    @NullAndEmptySource
    fun isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(input: String?) {
        assertThrows<IllegalArgumentException> { runException("pobi",input, "1") }
    }
    @Test
    fun `should parse valid car names`() {
        val input = "pobi,woni,jun"
        val cars = parseCarNames(input)
        assertThat(cars).hasSize(3)
        assertThat(cars.map { it.name }).containsExactly("pobi", "woni", "jun")
    }
    @Test
    fun `should throw exception for empty car name`() {
        val input = "pobi,,jun"
        val exception = assertThrows<IllegalArgumentException> { parseCarNames(input) }
        assertThat(exception.message).isEqualTo("Car names cannot be empty.")
    }
    @Test
    fun `should throw exception for car name longer than 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> { Car("pobiwoni") }
        assertThat(exception.message).isEqualTo("Car name must be non-empty and name cannot exceed 5 characters")
    }
    @Test
    fun `should move car when random number is 4 or greater`() {
        val car = Car("pobi")
        repeat(100) {
            if (shouldMove()) {
                car.position += 1
                assertThat(car.position).isGreaterThan(0)
            }
        }
    }
    @Test
    fun `should find multiple winners with same position`() {
        val cars = listOf(Car("pobi", 3), Car("woni", 3), Car("jun", 2))
        val winners = findWinners(cars)
        assertThat(winners.map { it.name }).containsExactlyInAnyOrder("pobi", "woni")
    }
    @Test
    fun `should find single winner`() {
        val cars = listOf(Car("pobi", 3), Car("woni", 2), Car("jun", 1))
        val winners = findWinners(cars)
        assertThat(winners.map { it.name }).containsExactly("pobi")
    }
    override fun runMain() {
        main()
    }
    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
