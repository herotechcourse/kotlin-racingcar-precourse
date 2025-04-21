package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `자동차는 주어진 라운드 수만큼 랜덤 값에 따라 전진 또는 정지한다`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val game = RacingGame(cars)

        val result = game.play(rounds = 3) { 4 } // 항상 전진 조건 (4 이상)

        // 3라운드니까 각 car는 position = 3
        val finalPositions = result.last()
        assertThat(finalPositions).containsExactly(
            "pobi" to 3,
            "woni" to 3
        )
    }

    @Test
    fun `가장 멀리 간 자동차가 우승자이다`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        val game = RacingGame(cars)

        // 전진 조건: pobi는 4 이상, woni와 jun은 3 이하
        val randoms = listOf(4, 3, 3, 4, 3, 3, 4, 3, 3) // pobi만 매번 이동

        var index = 0
        game.play(rounds = 3) {
            randoms[index++]
        }

        val winners = game.findWinners()
        assertThat(winners).containsExactly("pobi")
    }
}
