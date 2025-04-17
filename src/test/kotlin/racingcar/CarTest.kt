package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


class CarTest {

 @Test
 fun move() {
  val car = Car("pobi")

  repeat(100) {
   car.move()
  }
 assertThat(car.position).isGreaterThan(0)

 }
}