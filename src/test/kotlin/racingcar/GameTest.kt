package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.controller.GameController


private const val MOVING_FORWARD = 4
private const val STOP = 3

class GameTest {
  @Test
  fun `startRace should move all cars for each round and display the result`() {
    assertRandomNumberInRangeTest(
      {
        val car1 = Car("pobi")
        val car2 = Car("woni")
        val gameController = GameController(listOf(car1, car2), 1)
        gameController.startRace()
        assertThat(car1.getPosition()).isEqualTo(1)
        assertThat(car2.getPosition()).isEqualTo(0)
      },
      MOVING_FORWARD,
      STOP,
    )
  }
  @Test
  fun `getWinners should return the cars with the maximum position`() {
    val car1 = Car("pobi", 3)
    val car2 = Car("woni", 3)
    val car3 = Car("jun", 2)
    val gameController = GameController(listOf(car1, car2, car3), 1)
    val winners = gameController.getWinners()
    assertThat(winners).containsExactlyInAnyOrder(car1, car2)
  }
  @Test
  fun `getWinners should return multiple winners if there are ties`() {
    val car1 = Car("pobi", 3)
    val car2 = Car("woni", 3)
    val car3 = Car("jun", 2)
    val gameController = GameController(listOf(car1, car2, car3), 1)
    val winners = gameController.getWinners()
    assertThat(winners).containsExactlyInAnyOrder(car1, car2)
  }
}