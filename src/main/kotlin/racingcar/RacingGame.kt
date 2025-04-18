package racingcar

const val PROGRESS_BAR: String = "-"

class RacingGame {

    private lateinit var _cars: List<Car>
    private var _rounds: Int = 0

    private fun showCurrentRoundProgress () {
        for (car in _cars) {
            val (name, pos) = car.getCarInfo()
            println("$name : ${PROGRESS_BAR.repeat(pos)}")
        }
        println()
    }

    fun start() {
        println("Race Results")
        for (i in 1.._rounds) {
            _cars.forEach { car ->  car.playRound() }
            showCurrentRoundProgress()
        }
    }

    fun whoIsWinner() {
        val winnerPos: Int = _cars.maxOf { it.getCarInfo().second }
        val winners: String = _cars.filter { it.getCarInfo().second == winnerPos }.joinToString(transform = {car -> car.getCarInfo().first })

        println("Winners : $winners")
    }

    fun joinGame(carNames: List<String>, rounds: Int) {
        _cars = carNames.map { name -> Car(name)}
        _rounds = rounds
    }
}