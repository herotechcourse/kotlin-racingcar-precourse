package racingcar.observer

import racingcar.model.Car

/**
 * Listener interface for reacting to race events.
 */
interface RaceListener {

    /**
     * Called after each round with the current state of cars.
     */
    fun onRound(round: Int, cars: List<Car>)

    /**
     * Called once the race is complete with final car states and winners.
     */
    fun onFinish(cars: List<Car>, winners: List<String>)
}
