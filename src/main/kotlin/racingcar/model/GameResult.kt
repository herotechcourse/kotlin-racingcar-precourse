package racingcar.model

class GameResult {
    private val roundResults: MutableList<GameRoundResult> = mutableListOf()

    fun getRoundResults(): List<GameRoundResult> = roundResults

    fun findMaxMoveCount(): Int {
        val lastRoundCars = getCarsAtFinalRound().getCars();
        return lastRoundCars.maxOfOrNull { it.getMoveCount()} ?: 0
    }

    fun saveRoundResult(gameRoundResult: GameRoundResult) {
        roundResults.add(gameRoundResult)
    }

    fun getCarsAtFinalRound(): Cars {
        return roundResults.last().getCars()
    }
}
