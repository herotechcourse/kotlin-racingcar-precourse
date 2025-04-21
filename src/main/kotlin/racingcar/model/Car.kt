package racingcar.model

import racingcar.strategy.MovementStrategy

/**
 * Represents a car with a name and a current position.
 *
 * @property name the name of the car
 */
data class Car(val name: String, var position: Int = 0) {

    init {
        require(name.length in 1..5) {
            "The car name must be at least 1 character and no more than 5 characters. Input value: '$name'"
        }
    }

    /**
     * Moves the car forward using the provided strategy.
     *
     * @param strategy determines whether the car should move
     */
    fun move(strategy: MovementStrategy) {
        if (strategy.shouldMove()) position++
    }
}
