package racingcar.controller

import racingcar.model.Car

/**
 * Handle movement of [cars] for given number of [rounds]
 * Announce winner [cars] after given number of [rounds]
 * */
class Race(var cars: List<Car>, val rounds: Int) {

    /** Start and run the race for given number of [rounds] */
    fun start() {
        println()
        println("Race Results")
        repeat(rounds) {
            simulateRound()
            printStatus()
        }
        announceWinners()
    }

    /** Simulate racing round for each car in [cars] */
    fun simulateRound() {
        for (car in cars) {
            car.simulateRound()
        }
    }

    /** Output status for each car in [cars] */
    fun printStatus() {
        for (car in cars) {
            car.printStatus()
        }
        println()
    }

    /** Announce winners after given number of [rounds] */
    fun announceWinners() {
        val winners: MutableList<Car> = determineWinners()
        var winnerMessage = "Winners : "
        for (winner in winners) {
            if (winnerMessage.compareTo("Winners : ") != 0)
                winnerMessage += ", "
            winnerMessage += winner.name
        }
        println(winnerMessage)
    }

    /** Determine winners after given number of [rounds] */
    fun determineWinners(): MutableList<Car> {
        val maxDistance = cars.maxOf { it.distance }
        val winners: MutableList<Car> = mutableListOf()
        for (car in cars) {
            if (car.distance == maxDistance) {
                winners.add(car)
            }
        }
        return winners
    }
}