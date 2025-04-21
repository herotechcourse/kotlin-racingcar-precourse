package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names =  input.split(",").map { it.trim() }
        if (names.isEmpty() || names.any { it.isBlank() }) {
            throw IllegalArgumentException("자동차 이름은 공백이거나 비어있을 수 없습니다.")
        }
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.")
    }
}