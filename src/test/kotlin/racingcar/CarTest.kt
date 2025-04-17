package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

  @Test
  fun `getProgress returns correct number of dashes`() {
    val car = Car("ford", currLevel = 3)

    val progress = car.getProgress()

    assertThat(progress).isEqualTo("---")
  }

  @Test
  fun `getProgress returns empty string when progress is zero`() {
    val car = Car("bmw")

    val progress = car.getProgress()

    assertThat(progress).isEqualTo("")
  }

  @Test
  fun `tryMove can lead to movement over multiple rounds`() {
    val car = Car("audi")

    repeat(100) { car.tryMove() }

    assertThat(car.currLevel).isGreaterThan(0)
    assertThat(car.currLevel).isLessThanOrEqualTo(100)
  }
}
