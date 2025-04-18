package racingcar.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameValidatorTest {
    
    @Test
    fun `validate should not throw exception for valid names`() {
        // Given
        val validNames = listOf("a", "ab", "abc", "abcd", "abcde")
        
        // When & Then - No exception should be thrown
        CarNameValidator.validate(validNames)
    }
    
    @Test
    fun `validate should throw exception for empty list`() {
        // Given
        val emptyList = emptyList<String>()
        
        // When & Then
        assertThrows<IllegalArgumentException> {
            CarNameValidator.validate(emptyList)
        }
    }
    
    @Test
    fun `validate should throw exception for name exceeding max length`() {
        // Given
        val namesWithTooLong = listOf("abc", "abcdef")
        
        // When & Then
        assertThrows<IllegalArgumentException> {
            CarNameValidator.validate(namesWithTooLong)
        }
    }
    
    @Test
    fun `validate should throw exception for empty name`() {
        // Given
        val namesWithEmpty = listOf("abc", "")
        
        // When & Then
        assertThrows<IllegalArgumentException> {
            CarNameValidator.validate(namesWithEmpty)
        }
    }
}
