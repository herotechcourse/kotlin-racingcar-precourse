/**
 * Lane class
 */

package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomizedMoveLane {
    fun canMoveForward() : Boolean {
        return (Randoms.pickNumberInRange(0, 9) >= 4)
    }
}
