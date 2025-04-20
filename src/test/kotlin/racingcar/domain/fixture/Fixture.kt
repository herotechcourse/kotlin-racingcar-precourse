package racingcar.domain.fixture

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.base.NumberPickerBase

class Fixture {
    object MovableNumberPicker : NumberPickerBase {
        override fun pick(): Int = Randoms.pickNumberInRange(4, 9)
    }

    object UnmovableNumberPicker : NumberPickerBase {
        override fun pick(): Int = Randoms.pickNumberInRange(0, 3)
    }

    object FourMovingNumberPicker : NumberPickerBase {
        private val randomNumbers = mutableListOf(1, 2, 4, 5, 6, 9)
        override fun pick(): Int = randomNumbers.removeFirst()
    }

    object FiveMovingNumberPicker : NumberPickerBase {
        private val randomNumbers = mutableListOf(7, 7, 7, 5, 1, 9)
        override fun pick(): Int = randomNumbers.removeFirst()
    }
}