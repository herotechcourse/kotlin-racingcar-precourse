package racingcar.view.exception

object InputMessage {
    const val EXCEED_INT_RANGE = "must be between ${Int.MIN_VALUE} and ${Int.MAX_VALUE}"
    const val IS_NOT_NUMERIC = "must be numeric"
}