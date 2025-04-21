package racingcar.service.raceexecution

// Used as specified in the mission description
import camp.nextstep.edu.missionutils.Randoms

/**
 *  [ Goal ]
 *  1. Generate random number (0 - 9)
 *
 *  Param   : X
 *  Return  : generated number. (Int)
 */
fun generateRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}