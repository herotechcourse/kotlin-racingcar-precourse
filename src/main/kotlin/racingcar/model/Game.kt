package racingcar.model

class Game(private val cars: Cars, private val gameRound: Int) {

    companion object {
        const val MAX_GAME_ROUND = 1000
    }

    fun playGame(): GameResult {
        val result = GameResult()
        for (round in 0 until gameRound) {
            val roundResult = playRound()
            result.saveRoundResult(roundResult)
        }
        return result
    }

    private fun playRound(): GameRoundResult {
        cars.getCars().forEach { it.moveIfPossible() }
        return GameRoundResult(cars)
    }

    fun getGameRound(): Int = gameRound
}
