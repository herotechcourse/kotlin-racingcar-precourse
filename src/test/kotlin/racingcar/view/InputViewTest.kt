package racingcar.view

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class InputViewTest {

    @BeforeEach
    fun setup() {
        // Make sure test is not affected by previous tests
        Console.close()
    }
    
    @AfterEach
    fun tearDown() {
        // Reset Console state to not affect subsequent tests
        Console.close()
    }

    @Test
    @DisplayName("Should throw exception when car name exceeds 5 characters")
    fun shouldThrowExceptionWhenCarNameExceedsFiveCharacters() {
        // Prepare test input
        val input = "car1,toolong,car3"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        
        val inputView = InputView()
        
        // Assert that exception is thrown
        assertThatThrownBy { inputView.readCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot exceed 5 characters")
    }
    
    @Test
    @DisplayName("Rounds must be a positive integer")
    fun shouldThrowExceptionWhenRoundsIsNotPositive() {
        // Prepare test input
        val input = "0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
        
        val inputView = InputView()
        
        // Assert that exception is thrown
        assertThatThrownBy { inputView.readRounds() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Rounds must be a positive number")
    }
} 