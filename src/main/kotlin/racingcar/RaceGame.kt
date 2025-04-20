package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.util.InputValidator

object RaceGame {
    fun start() {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val carNames = InputValidator.validateCarNames(input)

        println("How many rounds will be played?")
        val roundInput = Console.readLine()
        val numberOfRounds = InputValidator.validateNumberOfRounds(roundInput)

        val cars = carNames.map { Car(it) }
        val race = Race(cars, numberOfRounds)

        race.start()
    }
}