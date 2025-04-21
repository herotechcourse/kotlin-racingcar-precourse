package racingcar.services

import camp.nextstep.edu.missionutils.Console

/**
 * Create a class which wrap Console.readLine()
 * for easier testing.
 */
class ConsoleReaderService {
    fun readLine(): String {
        return Console.readLine()
    }
}