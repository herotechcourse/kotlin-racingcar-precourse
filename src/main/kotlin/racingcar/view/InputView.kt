package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun input(): String {
        val input: String = Console.readLine()
        if (input.isBlank()) throw IllegalArgumentException("Input cannot be empty")
        return input.trim()
    }

    fun inputCarNames(): List<CarNameDto> {
        return input().split(",")
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .map { CarNameDto(it) }
    }

    fun inputTryCount(): TryCountDto {
        val tryCount: Int
        try {
            tryCount = Integer.parseInt(input())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Input must be a valid integer")
        }
        return TryCountDto(tryCount)
    }
}
