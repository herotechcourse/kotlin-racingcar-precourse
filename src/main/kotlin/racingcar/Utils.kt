package racingcar

import camp.nextstep.edu.missionutils.Randoms

object Utils {
  fun getRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
  }

  fun printResults(cars: List<Car>) {
    println("Race Results:")
    cars.forEach {
      println("${it.name} : ${it.getProgress()}")
    }
  }

  fun printWinners(cars: List<Car>) {
    val maxLevel = cars.maxOf { it.currLevel }
    val winners = cars.filter { it.currLevel == maxLevel }.map { it.name }
    println("Winners : ${winners.joinToString(", ")}")
  }

  fun parseCars(input: String): MutableList<Car> {
    return input.split(",")
      .map { it.trim() }
      .onEach {
        if (it.isEmpty()) {
          //TODO BREAK AND Throw error the car name shouldnt be empty
        }
      }
      .map { Car(it) }
      .toMutableList()
  }

}
