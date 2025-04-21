package racingcar.controller

import racingcar.model.Car

class Race(var cars: List<Car>, val rounds: Int) {

    fun start() {
        println()
        println("Race Results")
        repeat(rounds)
        {
            simulateRound()
            printStatus()
        }
        announceWinners()
    }

    fun simulateRound()
    {
        for (car in cars)
        {
            car.simulateRound()
        }
    }

    fun printStatus() {
        for (car in cars)
        {
            car.printStatus()
        }
        println()
    }

    fun determineWinners(): MutableList<Car> {
        val maxDistance = cars.maxOf {it.distance}
        val winners: MutableList<Car> = mutableListOf()
        for (car in cars) {
            if (car.distance == maxDistance) {
                winners.add(car)
            }
        }
        return winners
    }

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
}