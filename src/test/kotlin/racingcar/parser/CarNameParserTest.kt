package racingcar.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarNameParserTest {
    
    @Test
    fun `parse should split comma-separated names`() {
        // Given
        val input = "pobi,woni,jun"
        
        // When
        val names = CarNameParser.parse(input)
        
        // Then
        assertThat(names).containsExactly("pobi", "woni", "jun")
    }
    
    @Test
    fun `parse should trim whitespace from names`() {
        // Given
        val input = " pobi , woni , jun "
        
        // When
        val names = CarNameParser.parse(input)
        
        // Then
        assertThat(names).containsExactly("pobi", "woni", "jun")
    }
    
    @Test
    fun `parse should filter out empty names`() {
        // Given
        val input = "pobi,,woni,"
        
        // When
        val names = CarNameParser.parse(input)
        
        // Then
        assertThat(names).containsExactly("pobi", "woni")
    }
    
    @Test
    fun `parse should return empty list for empty input`() {
        // Given
        val input = ""
        
        // When
        val names = CarNameParser.parse(input)
        
        // Then
        assertThat(names).isEmpty()
    }
}
