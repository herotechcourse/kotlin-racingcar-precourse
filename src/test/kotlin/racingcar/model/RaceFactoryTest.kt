package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceFactoryTest {

    @Test
    fun `should create Race when input is valid`() {
        // Arrange
        val names = listOf("a", "b", "c")
        val roundCount = 5

        // Act
        val race = RaceFactory.create(names, roundCount)

        // Assert
        assertThat(race).isNotNull
    }

    @Test
    fun `should throw exception when car name list is empty`() {
        // Arrange
        val names = emptyList<String>()
        val roundCount = 5

        // Act
        // Assert
        assertThatThrownBy { RaceFactory.create(names, roundCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("At least one car is required.")
    }

    @Test
    fun `should throw exception when car name count exceeds limit`() {
        // Arrange
        val names = List(11) { "car$it" }
        val roundCount = 5

        // Act
        // Assert
        assertThatThrownBy { RaceFactory.create(names, roundCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car count must not exceed")
    }

    @Test
    fun `should throw exception when car names are not unique`() {
        // Arrange
        val names = listOf("a", "b", "a")
        val roundCount = 5

        // Act
        // Assert
        assertThatThrownBy { RaceFactory.create(names, roundCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car names must be unique.")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 101])
    fun `should throw exception when roundCount is out of valid range`(roundCount: Int) {
        // Arrange
        val names = listOf("a", "b", "c")

        // Act
        // Assert
        assertThatThrownBy { RaceFactory.create(names, roundCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be between")
    }


}
