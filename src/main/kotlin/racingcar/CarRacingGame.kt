package racingcar

class CarRacingGame(
    private val playersName: List<String>,
    private val limitRound: Int
) {
    private var currentRound = 0
    private val winners = mutableListOf<PlayerCar>()
    private val playerCars = mutableListOf<PlayerCar>()

    init {
        playersName.forEach { name ->
            playerCars.add(PlayerCar(name))
        }
    }


    fun gameProcess() {
        for (currentRound in 1..limitRound) {
            racePlayerCarsByRound()
            OutputController.printBlankLine()
        }
    }

    private fun racePlayerCarsByRound() {
        playerCars.forEach { playerCar ->
            val randomNum = RandomNumController.getRandomNum()
            playerCar.movingForward(randomNum)
            OutputController.printPlayerCarState(playerCar)
        }
    }

}