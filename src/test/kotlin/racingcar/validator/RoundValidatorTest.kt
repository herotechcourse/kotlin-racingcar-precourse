package racingcar.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RoundValidatorTest {
    
    @Test
    fun `validate should not throw exception for positive rounds`() {
        // Given
        val validRounds = 5
        
        // When & Then - No exception should be thrown
        RoundValidator.validate(validRounds)
    }
    
    @ParameterizedTest
    @ValueSource(ints = [0, -1, -5])
    fun `validate should throw exception for non-positive rounds`(rounds: Int) {
        // When & Then
        assertThrows<IllegalArgumentException> {
            RoundValidator.validate(rounds)
        }
    }
}
