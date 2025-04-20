/**
 * Lane class
 */

package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Lane {
    fun canMoveForward() : Boolean {
        return (Randoms.pickNumberInRange(0, 9) >= 4)
    }
}
