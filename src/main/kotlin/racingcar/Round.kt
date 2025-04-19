package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Round {

    fun moveCarForward(carNames: MutableMap<String, Int>, carName: String) {
        if (getRandomNumber() >= MOVING_FORWARD_CRITERIA) {
            carNames[carName] = carNames.getOrDefault(carName, 0) + MOVING_FORWARD_POINT
        }
    }

    fun getWinners(carNames: Map<String, Int>): List<String> {
        val maxMovementCount = carNames.maxOf { it.value }
        return carNames
            .filter { it.value == maxMovementCount }
            .map { it.key }
    }

    private fun getRandomNumber() =
        Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER)

    companion object {
        private const val RANDOM_START_NUMBER = 0
        private const val RANDOM_END_NUMBER = 9

        private const val MOVING_FORWARD_CRITERIA = 4
        private const val MOVING_FORWARD_POINT = 1
    }
}
