package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @packageName    : racingcar
 * @fileName       : InputTest
 * @author         : yong
 * @date           : 4/17/25
 * @description    :
 */
class InputTest {
    private val input = Input()

    @Test
    fun successCase() {
        val names = input.getNames("alex, bob, kate")
        assertEquals(listOf("alex", "bob", "kate"), names)
    }

    @Test
    @DisplayName("if some names are same, throw exception")
    fun failCase1() {
        assertThatThrownBy { input.getNames("alex, bob, alex") }
            .hasMessage("There is duplicated name")
    }

    @Test
    @DisplayName("if the car name's letter is under 5, get name list")
    fun failCase2() {
        assertThatThrownBy { input.getNames("alex, bobby, kate") }
            .hasMessage("name should be under 5 letters")
    }

    @Test
    @DisplayName("name is empty")
    fun failCase3() {
        assertThatThrownBy { input.getNames(" , bob, kate") }
            .hasMessage("name is empty")
    }


}