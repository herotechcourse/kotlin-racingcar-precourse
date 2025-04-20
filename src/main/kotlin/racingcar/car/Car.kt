package racingcar.car

import camp.nextstep.edu.missionutils.Randoms

private const val RANDOM_THRESHOLD = 4;

class Car(private val name: String) {
    private var distance: Int = 0

    fun moveForwardRandomly(): Int{
        if(shouldMoveForward())
            moveForward();
        return distance;
    }

    fun getName(): String{
        return name;
    }

    fun getDistance(): Int{
        return distance;
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(distance)}"
    }

    private fun moveForward() {
        distance++;
    }

    private fun shouldMoveForward(): Boolean {
        return generateNumber() >= RANDOM_THRESHOLD;
    }

    private fun generateNumber(): Int{
        return Randoms.pickNumberInRange(0, 9);
    }
}