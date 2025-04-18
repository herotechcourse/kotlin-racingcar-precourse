package racingcar.domain

import racingcar.car.Car

class Winner {
    fun determineWinners(carList: List<Car>): String {
        val maxPosition = getMaxPosition(carList)
        val winners = getWinners(carList, maxPosition)
        return winners.joinToString(", ")
    }

    private fun getMaxPosition(carList: List<Car>): Int {
        var maxPosition = 0
        for (car in carList) {
            if (car.position.length > maxPosition) {
                maxPosition = car.position.length
            }
        }
        return maxPosition
    }

    private fun getWinners(
        carList: List<Car>,
        maxPosition: Int
    ): MutableList<String> {
        val winners = mutableListOf<String>()
        for (car in carList) {
            if (car.position.length == maxPosition) {
                winners.add(car.carName)
            }
        }
        return winners
    }
}