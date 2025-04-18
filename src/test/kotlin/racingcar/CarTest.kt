package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {

 @Test
 fun `should initialize position to 0 when car is created`() {
  // Given
  val car = Car("pobi")

  // Then
  assertThat(car.position).isEqualTo(0)
 }

 @Test
 fun `should move the car when random number is greater than or equal to 4`() {
  // Given
  val car = Car("pobi")

  // When
  car.move(4)
  car.move(9)

  // Then
  assertThat(car.position).isEqualTo(2)
 }

 @Test
 fun `should not move the car when random number is less than 4`() {
  // Given
  val car = Car("pobi")

  // When
  car.move(3)
  car.move(0)

  // Then
  assertThat(car.position).isEqualTo(0)
 }

 @Test
 fun `should display car's name and position correctly`() {
  // Given
  val car = Car("pobi")

  // When
  car.move(5)
  car.move(6)

  // Then
  assertThat(car.display()).isEqualTo("pobi : --")
 }

 @Test
 fun `should increase position correctly when move is called multiple times`() {
  // Given
  val car = Car("pobi")

  // When
  car.move(5)
  car.move(6)
  car.move(7)

  // Then
  assertThat(car.display()).isEqualTo("pobi : ---")
 }
}
