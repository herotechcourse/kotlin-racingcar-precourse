package racingcar.core

class CarRaceGame (
    private val carsList: List<Car>) {

    fun playOneRound(){
        carsList.forEach{it.move()}
    }

    fun getWinners(): List<Car> {
        val winnersPosition = carsList.maxOf { it.position }
        val listWinners = carsList.filter { it.position == winnersPosition }
        return listWinners

    }
}