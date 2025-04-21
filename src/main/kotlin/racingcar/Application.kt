package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.ParseAndValidate.parseAndValidateNames
import racingcar.ParseAndValidate.parseAndValidateRounds

fun main() {
    val cars = getCarsList()
    val race = getRaceInstance(cars)
    println("\nRace Results")
    race.runRace()
    race.printResult()
}

fun getCarsList(): List<Car> {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames: List<String> = parseAndValidateNames(carNamesInput)
    return carNames.map { Car(it) }
}

fun getRaceInstance(cars: List<Car>): Race {
    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val rounds = parseAndValidateRounds(roundsInput)
    return Race(cars, rounds)
}
