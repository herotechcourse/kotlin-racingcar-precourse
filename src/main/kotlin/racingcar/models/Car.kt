package racingcar.models

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0) {
    fun race() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) position++
    }

    fun printStatus() {
        print("$name : ")
        repeat(position) {
            print("-")
        }
        println()
    }

    companion object {
        fun createCars(carNames: List<String>): List<Car> {
            val cars = mutableListOf<Car>()
            for (carName in carNames) {
                cars.add(Car(carName))
            }
            return cars
        }

        fun raceCars(cars: List<Car>, rounds: Int) {
            // TODO: currently throwing exception for non-positive input for rounds
            // decide whether handling of 0 rounds here instead is better
            if (rounds == 0)
                return
            println("Race Results")
            repeat(rounds) {
                for (car in cars) {
                    car.race()
                    car.printStatus()
                }
                println()
            }
        }

        fun printWinners (cars: List<Car>) {
            var maxPosition = 0
            for (car in cars) {
                if (car.position > maxPosition)
                    maxPosition = car.position
            }

            print("Winners : ")
            var winners = ""
            for (car in cars) {
                if (car.position == maxPosition) {
                    winners += car.name + ", "
                }
            }
            winners = winners.dropLast(2)
            print(winners) // Assumption: no newline at the end of the output needed
        }
    }
}
