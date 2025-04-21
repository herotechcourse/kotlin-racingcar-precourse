  package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ApplicationTest {

  @Test
  fun `car moves forward when random is 4 or more`() {
    val car = Car("test")
    
    repeat(750) {
      car.moveIfPossible()
    }
    assertThat(car.position).isGreaterThan(0)
  }
}
