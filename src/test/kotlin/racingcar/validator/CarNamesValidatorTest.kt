package racingcar.validator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarNamesValidatorTest {

    private val validator = CarNamesValidator()

    @Test
    @DisplayName("valid comma‑separated names are returned as trimmed list")
    fun `validate returns trimmed list on valid input`() {
        val raw = " Alfa , BMW,  KIA "
        val result = validator.validate(raw)
        assertThat(result)
            .containsExactly("Alfa", "BMW", "KIA")
    }

    @Test
    @DisplayName("blank name in list throws IllegalArgumentException")
    fun `validate throws on blank name`() {
        assertThatThrownBy { validator.validate("Ford, ,Audi") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car names must be non‑empty and ≤ 5 characters.")
    }

    @Test
    @DisplayName("name longer than 5 characters throws IllegalArgumentException")
    fun `validate throws on too‑long name`() {
        assertThatThrownBy { validator.validate("Toyota,Fiat") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car names must be non‑empty and ≤ 5 characters.")
    }

    @Test
    @DisplayName("empty input still triggers the blank/size rule")
    fun `validate throws on empty input`() {
        assertThatThrownBy { validator.validate("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car names must be non‑empty and ≤ 5 characters.")
    }
}