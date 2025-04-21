package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import racingcar.model.Car

private const val MOVING_FORWARD = 4
private const val STOP = 3

class CarTest {
  @Test
  fun `Car should not be created with empty name`() {
    assertThrows<IllegalArgumentException> { Car("") }
  }
  @Test
  fun `Car should not be created with name longer than 5 characters`() {
    assertThrows<IllegalArgumentException> { Car("abcdef") }
  }
  @Test
  fun `Car should not be created with blank name`() {
    assertThrows<IllegalArgumentException> { Car("   ") }
  }
  @Test
  fun `Car should move when random number is greater than or equal to 4`() {
    assertRandomNumberInRangeTest(
      {
        val car = Car("pobi")
        car.move()
        assertThat(car.getPosition()).isEqualTo(1)
      },
      MOVING_FORWARD,
      STOP,
    )
  }
  @Test
  fun `Car should not move when random number is less than 4`() {
    assertRandomNumberInRangeTest(
      {
        val car = Car("pobi")
        car.move()
        assertThat(car.getPosition()).isEqualTo(0)
      },
      STOP,
      MOVING_FORWARD,
    )
  }

}