package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class CarTest {
  // move() position logic test
  @RepeatedTest(10)
  fun `move function should either increase position by 1 or keep it same`() {
    val car = Car("pobi")
    val initialPosition = car.position
    car.move()
    assertThat(car.position).isBetween(initialPosition, initialPosition + 1)
  }
}
