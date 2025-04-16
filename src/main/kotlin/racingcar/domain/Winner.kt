package racingcar.domain

import racingcar.car.Car

class Winner {
    fun determineWinners(carList: List<Car>): String {
        var maxPosition = 0
        for (car in carList) {
            if (car.position.length > maxPosition) {
                maxPosition = car.position.length
            }
        }
        val winners = mutableListOf<String>()
        for (car in carList) {
            if (car.position.length == maxPosition) {
                winners.add(car.carName)
            }
        }
        return winners.joinToString(", ")
    }
}