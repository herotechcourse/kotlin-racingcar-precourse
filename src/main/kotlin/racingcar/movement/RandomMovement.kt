package racingcar.movement

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

/**
 * Movement strategy that uses a random number to decide if a car should move.
 * Cars move if the random value is 4 or higher.
 *
 * @param randomProvider Optionally injects a number supplier instead of using real randomness.
 */
class RandomMovement(
    private val randomProvider: () -> Int = { pickNumberInRange(0, 9) }
) : MovementStrategy {
    override fun shouldMove(): Boolean = randomProvider() >= 4
}
