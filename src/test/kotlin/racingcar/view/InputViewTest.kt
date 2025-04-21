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

    private val inputView = InputView()

    @BeforeEach
    fun setUp() {
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
    fun shouldThrowExceptionWhenCarNameTooLong() {
        assertThatThrownBy { 
            inputView.validateCarNames(listOf("toolong", "ok", "test"))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("cannot exceed 5 characters")
    }
    
    @Test
    @DisplayName("Should throw exception when round number is not positive")
    fun shouldThrowExceptionWhenRoundNumberNotPositive() {
        assertThatThrownBy { 
            inputView.validateRounds("0")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be positive")
    }
} 