package racingcar.controller

import racingcar.view.Display
import racingcar.model.Car
import racingcar.model.Race

class Executor(private val view: Display){
    private lateinit var cars: List<Car>
    private var rounds: Int = 0

    fun start() {
        val carNames = view.getValidNames()
        rounds = view.getValidRounds()
        cars = carNames.map { Car(it) }
    }

    fun race() {
        val race = Race()
        println("\nRace Results")
        repeat(rounds) {
            race.executeOneRound(cars)
            cars.forEach { println(it.toRaceResult()) }
            println()
        }
    }
}