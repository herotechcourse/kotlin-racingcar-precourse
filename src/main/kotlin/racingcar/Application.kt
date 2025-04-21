package racingcar

import racingcar.car.Car
import racingcar.input.ConsoleInput.readCarNames
import racingcar.input.ConsoleInput.readRounds
import racingcar.race.RacingGame
import racingcar.strategy.RandomMoveStrategy


fun main() {
    val cars = readCarNames().map(::Car)
    val rounds = readRounds()

    println("\nRace Results")
    val game = RacingGame(cars, rounds, RandomMoveStrategy)
    game.race()

    println("Winners : ${game.winners().joinToString { it.name }}")
}

