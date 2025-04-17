package racingcar

fun main() {
    val namesInput = prompt("Enter names of cars (max 5 chars): e.g. mike,mary,mo: ")
    val carNames = validateCarNames(namesInput)
    val cars = carNames.map { Car(it) }

    val roundsInput = prompt("Enter number of rounds to race: ")
    val rounds = validateRounds(roundsInput)

    val race = Race(cars, rounds)
    race.start()
}
