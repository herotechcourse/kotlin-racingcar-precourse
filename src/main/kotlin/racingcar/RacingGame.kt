package racingcar

class RacingGame(val cars: List<Car>, val round: Int) {

    fun startGame() {
        repeat(round) {
            playOneRound()
            Output.printGame(cars)
        }
    }

    fun findWinner() : List<Car> {
        val max = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == max }
    }

    private fun playOneRound() {
        for (car in cars) {
            car.move()
        }
    }

}