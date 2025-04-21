package racingcar

class Board {
    var cars: MutableList<Car> = mutableListOf()
        private set

    // Set cars
    fun setCars(newCar: Car) {
        cars.add(newCar)
    }

    // Print a round
    fun printRound() {
        for (car in cars) {
            println("${car.name} : ${car.result}")
        }
        println()
    }
    
    // Check the winners
    fun checkWinner(): List<String> {
        var winners = mutableListOf<String>()
        var max = 0

        for (car in cars) {
            if (car.result.length > max) {
                winners = mutableListOf<String>()
                winners.add(car.name)
                max = car.result.length
            } else if (car.result.length == max) {
                winners.add(car.name)
            }
        }

        return winners
    }
    
    // Print the result
    fun printResult(winners: List<String>) {
        println("Winners : ${winners.joinToString()}")
    }
}