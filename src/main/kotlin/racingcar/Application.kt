package racingcar

fun main() {
    val carNames = InputValidator.validateCarNames("pobi,woni")
    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars)

    repeat(5) {
        game.playRound()
    }
}
