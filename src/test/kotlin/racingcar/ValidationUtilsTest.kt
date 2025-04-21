import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.validateDuplicates
import racingcar.validateEmptyName
import racingcar.validateNameLength
import racingcar.validateRounds

class ValidationUtilsTest {
    @Nested
    inner class ValidateRoundsTest {
        @Test
        fun `should not fail if the number of rounds is more than zero`() {
            assertThatCode {
                validateRounds(3)
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should fail if the number of rounds less than one`() {
            assertThatThrownBy {
                validateRounds(0)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("The number of rounds cannot be zero or less.")
        }
    }

    @Nested
    inner class ValidateNameLengthTest {
        @Test
        fun `should not fail if the number of letters in the name doesn't exceed 5 characters`() {
            assertThatCode {
                validateNameLength("iggy")
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should fail if the number of letters in the name exceeds 5 characters`() {
            assertThatThrownBy {
                validateNameLength("Sergej")
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("The name must not exceed 5 characters.")
        }
    }

    @Nested
    inner class ValidateEmptyNameTest {
        @Test
        fun `should not fail if the name is not an empty string`() {
            assertThatCode {
                validateEmptyName("ar")
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should fail if the name is an empty string`() {
            assertThatThrownBy {
                validateEmptyName("")
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("The name must not be an empty string.")
        }
    }
    @Nested
    inner class ValidateDuplicatesTest {
        @Test
        fun `should not fail if the names list doesn't contain duplicates `() {
            assertThatCode {
                validateDuplicates(listOf("ar", "at", "ah"))
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should fail if the names list has duplicates` () {
            assertThatThrownBy {
                validateDuplicates(listOf("ar", "ar", "ay"))
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("The names should be unique.")
        }
    }

}
