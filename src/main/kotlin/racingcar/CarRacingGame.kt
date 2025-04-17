package racingcar

class CarRacingGame(
    playersName: List<String>,
    private val limitRound: Int
) {
    val winners = mutableListOf<PlayerCar>()
    val playerCars = mutableListOf<PlayerCar>()

    init {
        playersName.forEach { name -> playerCars.add(PlayerCar(name)) }
    }

    fun gameProcess() {
        OutputController.printRaceResults()
        for (currentRound in 1..limitRound) {
            racePlayerCarsByRound()
            OutputController.printBlankLine()
        }
        updateWinners()
        OutputController.printWinners(winners)
    }

    private fun racePlayerCarsByRound() {
        playerCars.forEach { playerCar ->
            val randomNum = RandomNumController.getRandomNum()
            playerCar.movingForward(randomNum)
            OutputController.printPlayerCarState(playerCar)
        }
    }

    fun updateWinners() {
        val maxDistance = playerCars.maxOf { it.distance }
        playerCars.forEach { playerCar -> addWinner(playerCar, maxDistance) }
    }

    private fun addWinner(playerCar: PlayerCar, maxDistance: Int) {
        if (playerCar.distance >= maxDistance) {
            winners.add(playerCar)
        }
    }

}