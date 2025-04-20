package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Cars

class CarRaceTest{

  @Test
  fun `playRaceRound moves all cars`() {
   val car1 = Car("Car1")
   val car2 = Car("Car2")
   val cars = Cars(listOf(car1, car2))
   val carRace = CarRace(cars)

   val initialPositions = cars.getCars().map { it.getPosition() }

      repeat(5) {
          carRace.playRaceRound()
      }

   val newPositions = cars.getCars().map { it.getPosition() }
   assertThat(newPositions[0]).isNotEqualTo(initialPositions[0])
  }
 }
