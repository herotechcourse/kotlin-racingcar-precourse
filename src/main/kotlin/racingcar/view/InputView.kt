package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return input.split(",").map { it.trim() }
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해야 합니다.")
    }
}