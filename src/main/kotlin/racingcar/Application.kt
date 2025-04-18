package racingcar

fun main() {
    val ioConsole = IOConsole()
    val inputHandler = InputHandler(
        io = ioConsole
    )
    val names = inputHandler.readCarNames()
    val rounds = inputHandler.readRoundCount()
    val game = RacingGame(names, rounds, ioConsole)
    game.start()
}