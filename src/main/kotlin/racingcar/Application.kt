package racingcar

fun main() {
    val nameInput: String = Input().input()
    val names: List<String> = Input().getNames(nameInput)
    val roundInput: String = Input().input()
    val round: Int = Input().getRound(roundInput)

    RacingService(names, round).play()
}
