package racingcar

fun main() {
    val cars = UserPrompt.promptCarNames()
    val rounds = UserPrompt.promptRounds()

    val race = Race(cars = cars, rounds = rounds)
    race.play()
    race.displayWinners()
}
