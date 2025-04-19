package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.core.Game
import racingcar.model.Car

class GameTest {

  @Test
  fun `getWinners returns single winner correctly`() {
    val cars = mutableListOf(
      Car("bmw", currLevel = 5),
      Car("ford", currLevel = 3),
      Car("audi", currLevel = 2)
    )

    val game = Game(cars, rounds = 0)

    val winners = game.getWinners()

    assertThat(winners).hasSize(1)
    assertThat(winners[0].name).isEqualTo("bmw")
  }

  @Test
  fun `getWinners returns multiple winners if tied`() {
    val cars = mutableListOf(
      Car("audi", currLevel = 4),
      Car("bmw", currLevel = 4),
      Car("kia", currLevel = 2)
    )

    val game = Game(cars, rounds = 0)

    val winners = game.getWinners()

    assertThat(winners).hasSize(2)
    assertThat(winners.map { it.name }).containsExactlyInAnyOrder("audi", "bmw")
  }

  @Test
  fun `startRace runs and progresses some cars`() {
    val cars = mutableListOf(
      Car("kia"),
      Car("ford"),
      Car("bmw")
    )

    val game = Game(cars, rounds = 20)
    game.startRace()

    cars.forEach {
      assertThat(it.currLevel).isBetween(0, 20)
    }
  }
}
