package racingcar

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val nameInput: String = Input().input()
    val names: List<String> = Input().getNames(nameInput)

    println("How many rounds will be played?")
    val roundInput: String = Input().input()
    val round: Int = Input().getRound(roundInput)

    RacingService(names, round).play()
}
