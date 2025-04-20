package racingcar

class Board {
    var cars: List<Car> = listOf()

    // Set cars
    fun setCars(newCars: List<Car>) {
        cars = newCars
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

        return winners
    }
    
    // Print the result
    fun printResult(winners: List<String>) {
        println("Winners : ${winners.joinToString()}")
    }
}