package racingcar

import racingcar.io.Output

class RacingGame(val cars: List<Car>, val round: Int) {

    fun startGame(gameService: GameService) {
        Output.printStartMessage()
        repeat(round) {
            playOneRound(gameService)
            Output.printGame(cars)
        }
    }

    fun findWinner() : List<Car> {
        val max = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == max }
    }

    private fun playOneRound(gameService: GameService) {
        gameService.playOneRound(cars)
    }

}