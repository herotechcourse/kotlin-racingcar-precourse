package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun input(): String {
        val input: String = Console.readLine()
        if (input.isBlank()) throw IllegalArgumentException("Input cannot be empty")
        return input
    }

    fun inputCarNames(input: String): List<CarNameDto> {
        return input.split(",")
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .map { CarNameDto(it) }
    }

}