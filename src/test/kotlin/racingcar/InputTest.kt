package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.io.Input

/**
 * @packageName    : racingcar
 * @fileName       : InputTest
 * @author         : yong
 * @date           : 4/17/25
 * @description    :
 */
class InputTest {
    private val input = Input()

    // Name Input Case
    @Test
    fun nameInputSuccessCase() {
        val names = input.getNames("alex, bob, kate")
        assertEquals(listOf("alex", "bob", "kate"), names)
    }

    @Test
    @DisplayName("if some names are same, throw exception")
    fun nameInputFailCase1() {
        assertThatThrownBy { input.getNames("alex, bob, alex") }
            .hasMessage("There is duplicated name")
    }

    @Test
    @DisplayName("if the car name's letter is under 5, get name list")
    fun nameInputFailCase2() {
        assertThatThrownBy { input.getNames("alex, michael, kate") }
            .hasMessage("name should be under 5 letters")
    }

    @Test
    @DisplayName("name is empty")
    fun nameInputFailCase3() {
        assertThatThrownBy { input.getNames(" , bob, kate") }
            .hasMessage("name is empty")
    }


    // Round Input Case
    @Test
    fun roundInputSeccessCase() {
        val round = input.getRound("3");
        assertEquals(3, round)
    }

    @Test
    @DisplayName("round cannot be converted to Integer")
    fun roundInputFailCase1() {
        assertThatThrownBy {
            input.getRound("0.1")
        }.isInstanceOf(NumberFormatException::class.java)
    }

    @Test
    @DisplayName("round cannot be converted to Integer")
    fun roundInputFailCase2() {
        assertThatThrownBy {
            input.getRound("Not number")
        }.isInstanceOf(NumberFormatException::class.java)

    }

    @Test
    @DisplayName("round is 0")
    fun roundInputFailCase3() {
        assertThatThrownBy { input.getRound("0") }
            .hasMessage("round should be positive number")
    }

    @Test
    @DisplayName("round should be positive number")
    fun nameInputFailCase4() {
        assertThatThrownBy { input.getRound("-2") }
            .hasMessage("round should be positive number")
    }

}