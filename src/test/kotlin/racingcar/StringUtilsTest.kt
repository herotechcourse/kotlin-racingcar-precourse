package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class StringUtilsTest{
    @Test
    fun `checkName should throw if name is blank`() {
        assertThatThrownBy { StringUtils.checkName("  ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("each car needs a name!")
    }

    @Test
    fun `checkName should throw if name exceeds 5 characters`() {
        assertThatThrownBy { StringUtils.checkName("Zarina") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("names cannot exceed 5 characters!")
    }

    @Test
    fun `checkName should pass for valid name`() {
        assertDoesNotThrow {
            StringUtils.checkName("Quick")
        }
    }

    @Test
    fun `hasDuplicateNames should throw if there are duplicates`() {
        val names = listOf("CarA", "CarB", "CarA")
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringUtils.hasDuplicateNames(names)
        }
        assertEquals("More than one car have the same name!", exception.message)
    }

    @Test
    fun `hasDuplicateNames should do nothing if all names are unique`() {
        val names = listOf("CarA", "CarB", "CarC")
        assertDoesNotThrow {
            StringUtils.hasDuplicateNames(names)
        }
    }

    @Test
    fun `generateCars should return list of cars with given names`() {
        val names = listOf("A", "B", "C")
        val cars = StringUtils.generateCars(names)

        assertThat(cars).hasSize(3)
        assertThat(cars.map { it.name }).containsExactly("A", "B", "C")
    }
}