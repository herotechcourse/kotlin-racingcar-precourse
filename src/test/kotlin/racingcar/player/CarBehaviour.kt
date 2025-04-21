package racingcar.player

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarBehaviour {

  @Test
  fun `cars should not move if random number is between 0 and 3`() {
    val cars = listOf(Car("Car1"), Car("Car2"), Car("Car3"), Car("Car4"))

    assertRandomNumberInRangeTest(
        {
          cars.forEach { it.attemptMovement() }
          cars.forEach { car -> assertThat(car.position).isEqualTo(0) }
        },
        0,
        1,
        2,
        3)
  }

  @Test
  fun `cars should move if random number is between 4 and 9`() {
    val cars = listOf(Car("Car1"), Car("Car2"), Car("Car3"), Car("Car4"), Car("Car5"))

    assertRandomNumberInRangeTest(
        {
          cars.forEach { it.attemptMovement() }
          cars.forEach { car -> assertThat(car.position).isEqualTo(1) }
        },
        4,
        5,
        6,
        7,
        8,
        9)
  }

  @Test
  fun `progress bar length should match position`() {
    val car = Car("Car1")
    repeat(5) { car.attemptMovement() }
    assertThat(car.progressBar().length).isEqualTo(car.position)
  }

  @Test
  fun `progress bar should not contain spaces if position is more than 0`() {
    val car = Car("Car2")
    repeat(5) { car.attemptMovement() }
    assertThat(car.progressBar()).doesNotContain(" ")
  }

  @Test
  fun `progress bar should be empty when position is 0`() {
    val car = Car("Car3")
    repeat(0) { car.attemptMovement() }
    assertThat(car.progressBar()).isEmpty()
  }

  @Test
  fun `progress bar should return a String`() {
    val car = Car("Car4")
    repeat(0) { car.attemptMovement() }
    assertThat(car.progressBar()).isInstanceOf(String::class.java)
  }
}
