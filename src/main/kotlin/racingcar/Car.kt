package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String) {

    private var _movementCount = 0
    val movementCount: Int
        get() = _movementCount

    fun moveForward(startNumber: Int, endNumber: Int) {
        if (isMovableForward(startNumber, endNumber)) {
            _movementCount += 1
        }
    }

    private fun isMovableForward(startNumber: Int, endNumber: Int) =
        Randoms.pickNumberInRange(startNumber, endNumber) >= MOVING_FORWARD_CRITERIA

    companion object {
        private const val MOVING_FORWARD_CRITERIA = 4
    }
}
