package racingcar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("RacingGame getwinners act")

class RacingGameTest {
    @Test
    fun `highest rank cars win together`(){
        val game = RacingGame(listOf("pobi","woni","jun"))
        game.cars[0].position = 2
        game.cars[1].position = 2
        game.cars[2].position = 1

        val winners = game.getWinners()
        assertThat(winners).containsExactlyInAnyOrder("pobi","woni")
    }
}