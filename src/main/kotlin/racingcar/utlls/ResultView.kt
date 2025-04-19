package racingcar.utlls

import racingcar.core.Car

object ResultView {
    fun displayEndPositions(carsList: List<Car>) {
        carsList.forEach { it.display() }
    }

    fun printFinalWinners(listWinners: List<Car>) {
        val listWinnersNames = listWinners.joinToString(", ") { it.name }
        println("Winners : $listWinnersNames")
    }
}