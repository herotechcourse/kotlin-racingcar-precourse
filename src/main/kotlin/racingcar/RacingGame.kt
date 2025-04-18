package racingcar

const val PROGRESS_BAR: String = "-"

class RacingGame {

    private lateinit var _cars: List<Car>
    private var _rounds: Int = 0

    fun joinGame(carNames: List<String>, rounds: Int) {
        _cars = carNames.map { name -> Car(name)}
        _rounds = rounds
    }
}