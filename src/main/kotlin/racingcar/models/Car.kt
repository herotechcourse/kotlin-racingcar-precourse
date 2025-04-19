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
            println("Race Results")
            repeat(rounds) {
                for (car in cars) {
                    car.race()
                    car.printStatus()
                }
                println()
            }
        }

        fun findMaxPosition(cars: List<Car>): Int {
            var maxPosition = 0
            for (car in cars) {
                if (car.position > maxPosition) {
                    maxPosition = car.position
                }
            }
            return maxPosition
        }

        fun printWinners(cars: List<Car>) {
            val maxPosition = findMaxPosition(cars)

            print("Winners : ")
            var winners = ""
            for (car in cars) {
                if (car.position == maxPosition) {
                    winners += car.name + ", "
                }
            }
            winners = winners.dropLast(2)

            // Assumption: the output in the example execution in the
            // input/output requirements does not include a newline at the end
            print(winners)
        }
    }
}
