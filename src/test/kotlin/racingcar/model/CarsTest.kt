package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarsTest{

 @Test
 fun `from creates cars correctly`() {
  val names = listOf("CarA", "CarB", "CarC")
  val cars = Cars.from(names)
  assertThat(cars.getCars().map { it.name }).containsExactly("CarA", "CarB", "CarC")
 }

 @Test
 fun `findWinners returns cars with max position`() {
  val car1 = Car("Car1")
  val car2 = Car("Car2")
  val car3 = Car("Car3")

  repeat(3) { car1.move() }
  repeat(5) { car2.move() }
  repeat(5) { car3.move() }

  val cars = Cars(listOf(car1, car2, car3))

  val winners = cars.findWinners()

  val maxPosition = winners.first().getPosition()
  assertThat(winners).allMatch { it.getPosition() == maxPosition }
 }

 }