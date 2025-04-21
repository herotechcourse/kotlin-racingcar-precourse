package racingcar.model

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["bmw", "benz"])
    fun `should create Name when it is 5 characters or fewer`(name: String) {
        // Act
        // Assert
        assertThatCode { Name(name) }
            .doesNotThrowAnyException()
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "   "])
    fun `should throw exception when Name is blank`(name: String) {
        // Act
        // Assert
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car must have a name.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["porsche", "lamborghini"])
    fun `should throw exception when name exceeds 5 characters`(name: String) {
        // Act
        // Assert
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Name cannot exceed 5 characters.")
    }
}
