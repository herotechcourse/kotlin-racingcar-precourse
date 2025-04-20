package racingcar.repository

import camp.nextstep.edu.missionutils.Randoms

private const val RANDOM_THRESHOLD = 4;

class Car(val name: String) {
    private var distance: Int = 0

    fun moveForward() {
        distance++;
    }

    fun moveForwardRandomly(){
        if(shouldMoveForward())
            moveForward();
    }

    private fun shouldMoveForward(): Boolean {
        return generateNumber() >= RANDOM_THRESHOLD;
    }

    private fun generateNumber(): Int{
        return Randoms.pickNumberInRange(0, 9);
    }
}