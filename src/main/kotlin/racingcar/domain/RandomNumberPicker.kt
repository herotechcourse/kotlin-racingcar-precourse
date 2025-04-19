package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.base.NumberPickerBase

object RandomNumberPicker : NumberPickerBase {
    private const val MINIMUM = 0
    private const val MAXIMUM = 9

    override fun pick() = Randoms.pickNumberInRange(MINIMUM, MAXIMUM)
}