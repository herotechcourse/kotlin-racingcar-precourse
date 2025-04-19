package racingcar

fun main() {
    val prompt = UserPrompt()
    val cars = prompt.promptCarNames()
    val rounds = prompt.promptRounds()

    val race = Race(cars = cars, totalRounds = rounds)
    race.play()
    race.displayWinners()
}
