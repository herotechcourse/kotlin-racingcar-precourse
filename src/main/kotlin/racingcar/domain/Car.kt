package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car in the racing simulation.
 * Each car has a name and track its forward progression during the race.
 */
class Car(val name: String) {
    var progression: Int = 0
      private set

    /**
     * Move the car forward based on random chance.
     * Car moves forward if random number is 4 or greater.
     */
    fun progress() {
        if (canMove()) {
            ++progression
        }
    }

    /**
     * Determines if the car can move forward based on random chance.
     * Returns true if the random number (0-9) is at least 4.
     */
    private fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}