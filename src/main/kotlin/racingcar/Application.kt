package racingcar

import racingcar.config.Config
import racingcar.domain.Race
import racingcar.frontend.Frontend
import racingcar.model.Car
import racingcar.observer.ConsoleListener
import racingcar.observer.RaceObserver
import racingcar.strategy.RandomMovementStrategy
import racingcar.validation.CarNameValidator
import racingcar.validation.RoundValidator

/**
 * Application entry point.
 */
fun main() {
    // Read raw user input
    val rawCarNames = Frontend.readCarNames()
    val carNames = CarNameValidator.validate(rawCarNames)

    val rawRounds = Frontend.readRounds()
    val rounds = RoundValidator.validate(rawRounds)

    val cars = carNames.map { Car(it) }
    val observer = RaceObserver(listOf(ConsoleListener()))
    val race = Race(cars, rounds, RandomMovementStrategy, observer)

    print("\nRace Results")
    race.start()
}
