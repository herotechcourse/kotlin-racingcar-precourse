package racingcar.raceexecution

/**
 *  [ Goal ]
 *  1. Generate random number (0 - 9)
 *
 *  Param   : X
 *  Return  : generated number. (Int)
 */
fun generateRandomNumber(): Int {
    val result: Int = (Math.random()*10).toInt()
    return (result)
}