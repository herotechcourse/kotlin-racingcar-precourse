package racingcar

object Simulation {
    fun run(cars: List<Car>, totalRounds: Int) {
        println("--------------------------")
        for (round in 1..totalRounds) { // todo: avoid +2 level nesting and split in more functions
            println("Round $round")
            for (car in cars) {
                println("--- Car n${car.id} ---")
                println(" Name: ${car.name}")
                println(" Position: ${car.position}")
                println(" Progress: ${car.progressBar()}")
                val movement = car.attemptMovement()
                println(" Movement: ${movement}")
                println(" Position: ${car.position}")
                println(" Progress: ${car.progressBar()}")
            }
            println("--------------------------")
        }
    }
}
