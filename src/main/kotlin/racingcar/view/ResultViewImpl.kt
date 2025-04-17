package racingcar.view

import racingcar.model.Car

class ResultViewImpl: ResultView {
    override fun printResultHeader() {
        println("Race Results")
    }

    override fun printResultRounds(car: Car) {
        print("${car.carName} : ${Car.progressChar.toString().repeat(car.progress)}")
    }

    override fun printResultWinner(carWinner: String) {
        println("Winner : $carWinner")
    }
}