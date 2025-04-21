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

    fun fourMovingNumberPicker(): NumberPickerBase {
        val randomNumbers = mutableListOf(1, 2, 4, 5, 6, 9)
        return object : NumberPickerBase {
            override fun pick(): Int = randomNumbers.removeFirst()
        }
    }

    fun fiveMovingNumberPicker(): NumberPickerBase {
        val randomNumbers = mutableListOf(7, 7, 7, 5, 1, 9)
        return object : NumberPickerBase {
            override fun pick(): Int = randomNumbers.removeFirst()
        }
    }
}