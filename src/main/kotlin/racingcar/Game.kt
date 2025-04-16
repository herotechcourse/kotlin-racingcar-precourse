package racingcar

import racingcar.Utils.getRandomNumber

class Game(val cars: MutableList<Car>,val rounds: Int) {

  fun startRace() {
    repeat(rounds) {
      cars.forEach { car ->
        val shouldMove = getRandomNumber() >= 4
        if (shouldMove) car.move()
      }
    }
  }
}
