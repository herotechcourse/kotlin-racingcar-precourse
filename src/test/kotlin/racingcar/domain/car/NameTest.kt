package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["a2", "a+a", "a b", "a!"])
    fun `throw exception when the name contains non-alphabet characters`(name: String) {
        // when & then
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Car name must only contain alphabets and commas.")
    }

    @Test
    fun `throw exception when the name length is out of range`() {
        // given
        val name = "jihyun"
        // when & then
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Car name length must be between $MIN_LENGTH and $MAX_LENGTH.")
    }

    @Test
    fun `recognize as the same object if names are the same`() {
        // given
        val name1 = Name("abc")
        val name2 = Name("abc")
        // when & then
        assertThat(name1).isEqualTo(name2)
        assertThat(name1.hashCode()).isEqualTo(name2.hashCode())
    }

    companion object {
        private const val MIN_LENGTH: Int = 1
        private const val MAX_LENGTH: Int = 5
    }
}
