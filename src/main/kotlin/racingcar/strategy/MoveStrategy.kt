package racingcar.strategy

import camp.nextstep.edu.missionutils.Randoms

fun interface MoveStrategy {
    fun canMove(): Boolean
}
