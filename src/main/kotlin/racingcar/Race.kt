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
        for (carName in this.carNames) {
            val car = Car()
            car.setCarName(carName)
            this.cars.add(car)
        }
    }

    fun start() {
        while (areRoundsRemaining()) {
            this.processRound()
        }
    }

    fun areRoundsRemaining(): Boolean {
        return this.rounds > 0
    }

    private fun processRound() {
        for (car in this.cars) {
            updateCarProgress(car)
            displayCarProgress(car)
        }
        println()
        proceedToNextRound()
    }

    fun updateCarProgress(car: Car) {
        if (isCarAdvancing()) {
            car.increasePosition()
        }
    }

    fun isCarAdvancing(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    fun displayCarProgress(car: Car) {
        var progressBar = ""
        for (i in 1..car.position) {
            progressBar += "-"
        }
        println(car.name + " : " + progressBar)
    }

    fun proceedToNextRound() {
        this.rounds--
    }

    fun announceWinners() {
        val maxProgress = this.cars.maxOf { it.position }
        val winners: String = this.cars.filter { it.position == maxProgress }
                                    .map { it.name }.joinToString(", ")
        println("Winners : $winners")
    }
}