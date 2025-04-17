package racingcar

class RaceGame(
    private val cars: List<Car>,
    private val roundNumber : Int) {

    fun raceAllRound() : List<Car> {
        for (i in 1..roundNumber) {
            raceOneRound(cars)
        }

        return cars
    }

    private fun raceOneRound(cars: List<Car>) {
        for (car in cars) {
            car.goForward()
        }
    }
}
