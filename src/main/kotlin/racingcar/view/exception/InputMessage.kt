package racingcar.view.exception

import racingcar.view.MAXIMUM_RANGE
import racingcar.view.MINIMUM_RANGE

object InputMessage {
    const val OUT_OF_VALID_RANGE = "must be between '${MINIMUM_RANGE}' and '${MAXIMUM_RANGE}'"
    const val IS_NOT_NUMERIC = "must be numeric"
}