package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerDeterminerTest {

 @Test
 fun `findWinners should return the name of the car with the highest position`() {
  // Given
  val car1 = Car("car1").apply { position = 3 }
  val car2 = Car("car2").apply { position = 5 }
  val car3 = Car("car3").apply { position = 2 }
  val cars = listOf(car1, car2, car3)
  val winnerDeterminer = WinnerDeterminer()

  // When
  val winners = winnerDeterminer.findWinners(cars)

  // Then
  assertThat(winners).containsExactly("car2")
 }

 @Test
 fun `findWinners should return all cars with the same highest position`() {
  // Given
  val car1 = Car("car1").apply { position = 5 }
  val car2 = Car("car2").apply { position = 5 }
  val car3 = Car("car3").apply { position = 3 }
  val cars = listOf(car1, car2, car3)
  val winnerDeterminer = WinnerDeterminer()

  // When
  val winners = winnerDeterminer.findWinners(cars)

  // Then
  assertThat(winners).containsExactly("car1", "car2")
 }
}
