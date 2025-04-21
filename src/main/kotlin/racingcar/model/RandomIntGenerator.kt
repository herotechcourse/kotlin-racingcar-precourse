package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

interface IntGeneratorStrategy {
    fun getIntValue(): Int
}

class RandomIntGenerator : IntGeneratorStrategy {
    override fun getIntValue(): Int =
        Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
    }
}

class MaxValueIntGeneratorStrategy : IntGeneratorStrategy {
    override fun getIntValue(): Int = MAX_NUMBER

    companion object {
        private const val MAX_NUMBER = 9
    }
}

class MinValueIntGeneratorStrategy : IntGeneratorStrategy {
    override fun getIntValue(): Int = MIN_NUMBER

    companion object {
        private const val MIN_NUMBER = 0
    }
}

