package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race {
    var carNames: List<String> = emptyList()
        private set
    var rounds: Int = 0
        private set
    var cars = mutableListOf<Car>()
        private set

    fun setCarNames(carNames: List<String>) {
        this.carNames = carNames
    }

    fun setRounds(rounds: Int) {
        this.rounds = rounds
    }

    fun initializeCars() {
        for (carName in carNames) {
            val car = Car()
            car.setCarName(carName)
            cars.add(car)
        }
    }

    fun run() {
        while (this.rounds > 0) {
            this.advanceRounds()
        }
    }

    private fun advanceRounds() {
        for (car in cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increaseProgress()
            }

            var progressBar = ""
            for (i in 1..car.progress) {
                progressBar += "-"
            }

            println(car.name + " : " + progressBar)
        }
        println()
        rounds--
    }

    fun announceWinners() {
        val maxProgress = cars.maxOf { it.progress }
        val winners: String = cars.filter { it.progress == maxProgress }
                                    .map { it.name }.joinToString(", ")
        println("Winners : $winners")
    }
}