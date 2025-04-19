package racingcar.raceexecution

/**
 *  [ Logic ]
 *  Check, if random number is same or over 4.
 *      Param   : (int) random number
 *      Return  : (bool) true, false
 */

fun isMoveConditionMet (input : Int) : Boolean {
    if (input >= 4)
        return true
    else
        return false
}