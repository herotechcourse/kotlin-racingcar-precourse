package racingcar.models

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0) {
    /**
     * According to the requirements the car moves forward
     * if a random number between 0-9 is at least 4.
     */
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
        fun createCars(carNames: List<String>): List<Car> = carNames.map { Car(it) }

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

            val winners = cars
                .filter { it.position == maxPosition } // keep only winners
                .map { it.name } // transform each car into just its name
                .joinToString(", ") // combine names, comma-separated, into one string

            // Assumption: the output in the example execution in the
            // input/output requirements does not include a newline at the end
            print(winners)
        }
    }
}
