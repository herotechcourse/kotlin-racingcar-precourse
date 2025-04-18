package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `should return true when random number is greater than or equal to threshold`() {
        // Given & When & Then
        assertRandomNumberInRangeTest(
            {
                val isMovable = Game.isMovable()
                assertThat(isMovable).isEqualTo(true)
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `should return false when random number is less than threshold`() {
        // Given & When & Then
        assertRandomNumberInRangeTest(
            {
                val isMovable = Game.isMovable()
                assertThat(isMovable).isEqualTo(false)
            },
            STOP
        )
    }

    @Test
    fun `should move only specific cars forward in round 1 based on random values`() {
        // Given
        val cars = listOf(Car("pobi", 1), Car("woni", 2), Car("jun", 3))

        // When & Then
        assertRandomNumberInRangeTest(
            {
                val updated = Game.playOneRound(cars)
                assertThat(updated).contains(Car("pobi", 2), Car("woni", 2), Car("jun", 3))
            },
            MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `should move correct cars forward across two rounds based on random values`() {
        // Given
        var cars = listOf(Car("pobi", 1), Car("woni", 2), Car("jun", 3))

        // When & Then
        assertRandomNumberInRangeTest(
            {
                repeat(2) { cars = Game.playOneRound(cars) }
                assertThat(cars).contains(Car("pobi", 3), Car("woni", 2), Car("jun", 4))
            },
            // 1st round
            MOVING_FORWARD, STOP, STOP,
            // 2nd round
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `should return single winner when one car has highest position`() {
        // Given
        val cars: List<Car> = listOf(Car("pobi", 1), Car("woni", 2), Car("jun", 3))

        // When
        val winners = Game.getWinners(cars)

        // Then
        assertThat(winners).contains(Car("jun", 3))
    }

    @Test
    fun `should return multiple winners when more than one car shares highest position`() {
        // Given
        val cars: List<Car> = listOf(Car("pobi", 1), Car("woni", 2), Car("jun", 2))

        // When
        val winners = Game.getWinners(cars)

        // Then
        assertThat(winners).contains(Car("woni", 2), Car("jun", 2))
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}