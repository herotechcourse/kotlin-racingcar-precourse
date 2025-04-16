package racingcar

class RacingGame(val cars: List<Car>, val round: Int) {

    fun startGame() {
        repeat(round) {
            playOneRound()
            Output.printGame(cars)
        }
    }

    private fun playOneRound() {
        for (car in cars) {
            car.move()
        }
    }

}