package racingcar.util

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class InputTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi.woni", "pobi/jun", "woni:jun"])
    fun `Occur exception when user input car name without comma`(inputCarNames: String) {
        assertThrows<IllegalArgumentException> {
            validateSpecialCharacter(inputCarNames)
        }
    }

    @ParameterizedTest
    @MethodSource("onlyOneCarName")
    fun `Occur exception when user input only one car name`(inputCarNames: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateInputNameCount(inputCarNames)
        }
    }

    @ParameterizedTest
    @MethodSource("carNameWithBlank")
    fun `Occur exception when user input car name with blank or nothing`(inputCarNames: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateBlankName(inputCarNames)
        }
    }

    @ParameterizedTest
    @MethodSource("carNameLengthExceedFive")
    fun `Occur exception when user input car name length exceed five`(inputCarNames: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateNameLength(inputCarNames)
        }
    }

    @ParameterizedTest
    @MethodSource("duplicateCarNameInCarNames")
    fun `Occur exception when user input duplicate car name`(inputCarNames: List<String>) {
        assertThrows<IllegalArgumentException> {
            validateDuplicateName(inputCarNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-3", "-123123123123"])
    fun `Occur exception when user input negative number`(inputRoundNumber: String) {
        assertThrows<IllegalArgumentException> {
            validateNegativeNumber(inputRoundNumber)
        }
    }

    @ParameterizedTest
    @ValueSource(strings =["123124a1", "abcdef"])
    fun `Occur exception when user input with other characters that not number`(inputRoundNumber: String) {
        assertThrows<IllegalArgumentException> {
            validateNumber(inputRoundNumber)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2147483648", "10000000000"])
    fun `Occur exception when user input round number exceed integer range`(inputRoundNumber: String) {
        assertThrows<IllegalArgumentException> {
            validateNumberRange(inputRoundNumber)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0])
    fun `Occur exception when user input zero`(roundNumber: Int) {
        assertThrows<IllegalArgumentException> {
            validateZero(roundNumber)
        }
    }

    companion object {
        @JvmStatic
        fun onlyOneCarName(): List<Arguments> = listOf(
            Arguments.arguments(listOf("pobi")),
            Arguments.arguments(listOf("woni")),
            Arguments.arguments(listOf("jun"))
        )

        @JvmStatic
        fun carNameWithBlank(): List<Arguments> = listOf(
            Arguments.arguments(listOf("woni", " ")),
            Arguments.arguments(listOf("", "pobi", "jun")),
            Arguments.arguments(listOf(" ", ""))
        )

        @JvmStatic
        fun carNameLengthExceedFive(): List<Arguments> = listOf(
            Arguments.arguments(listOf("cheonhyeonwoo")),
            Arguments.arguments(listOf("hyeonw"))
        )

        @JvmStatic
        fun duplicateCarNameInCarNames(): List<Arguments> = listOf(
            Arguments.arguments(listOf("pobi", "pobi")),
            Arguments.arguments(listOf("jun", "woni", "cheno", "woni"))
        )
    }
}