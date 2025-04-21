package racingcar.service

import racingcar.model.Car

/**
 * Starts the race and runs it for the specified number of rounds
 */

object Race {
    fun startRace(cars: List<Car>, rounds: Int) {
        validate(cars, rounds)
        println("Race results by round:")

       // If there's only one car, don't race - just display initial state
        if (cars.size == 1) {
            showResults(cars)
            return
        }

        for (round in 1..rounds) {
            moveForward(cars)
            showResults(cars)
        }
    }

    /**
     * Runs a single round of the race, moving each car
     */
    private fun moveForward(cars: List<Car>) {
        cars.forEach { it.moveForward() }
    }

    /**
     * Displays the results after a round
     */
    private fun showResults(cars: List<Car>) {
        println(cars.joinToString(",") { "${it.name} : ${"-".repeat(it.getPosition())}" })

    }

    /**
     * Determines the winners of the race
     * @return List of car names that are winners
     */
    fun getWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOfOrNull { it.getPosition()} ?: 0
        return cars.filter { it.getPosition() == maxPosition }.map { it.name }
    }

    private fun validate(cars: List<Car>, rounds: Int) {
        if (cars.isEmpty()) {
            throw IllegalArgumentException("At least one car is required")
        }
        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be positive")
        }

    }
}