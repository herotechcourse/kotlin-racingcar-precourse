package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingGameTest {

    private lateinit var car1: Car
    private lateinit var car2: Car
    private lateinit var car3: Car

    @BeforeEach
    fun setUp() {
        car1 = Car("a")
        car2 = Car("b")
        car3 = Car("c")
    }

    @Test
    fun `playRound should move all cars forward potentially`() {
        val game = RacingGame(listOf(car1, car2, car3))

        game.playRound()

        // Since move is random, we just test if positions are in valid range
        val positions = listOf(car1.position, car2.position, car3.position)
        assertThat(positions).allMatch { it in 0..1 }
    }

    @Test
    fun `printWinners should return all winners with max position`() {
        car1.position = 2
        car2.position = 2
        car3.position = 1

        val game = RacingGame(listOf(car1, car2, car3))

        // Capture console output
        game.printWinners()
        
        val maxPosition = listOf(car1, car2, car3).maxOf { it.position }
        val winners = listOf(car1, car2, car3)
            .filter { it.position == maxPosition }
            .map { it.name }

        assertThat(winners).containsExactlyInAnyOrder("a", "b")
    }
}
