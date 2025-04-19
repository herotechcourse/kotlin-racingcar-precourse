package racingcar.io

import camp.nextstep.edu.missionutils.Console

/**
 * @packageName    : racingcar
 * @fileName       : Input
 * @author         : yong
 * @date           : 4/16/25
 * @description    :
 */
class Input {
    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_ROUND = 1
    }

    fun input(): String {
        return Console.readLine()
    }

    fun getNames(input: String): List<String> {
        val names: List<String> = input.split(",").map { it.trim() }

        if (names.size != names.toSet().size) {
            throw IllegalArgumentException("There is duplicated name")
        }
        for (i in 0 until names.size) {
            if (names[i].length > MAX_NAME_LENGTH) {
                throw IllegalArgumentException("name should be under 5 letters")
            }
            if (names[i].isEmpty()) {
                throw IllegalArgumentException("name is empty")
            }
        }
        return names
    }

    fun getRound(input: String): Int {
        val round: Int = input.toInt()
        if (round < MIN_ROUND) {
            throw IllegalArgumentException("round should be positive number")
        }
        return round
    }
}