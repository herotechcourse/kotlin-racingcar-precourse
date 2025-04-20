package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {

    // Generates a list of random numbers between 0 and 9
    fun generate(count: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in 0 until count) {
            result.add(Randoms.pickNumberInRange(0, 9))
        }
        return result
    }
}
