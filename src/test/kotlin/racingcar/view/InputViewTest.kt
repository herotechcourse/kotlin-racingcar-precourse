package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import camp.nextstep.edu.missionutils.Console

class InputViewTest {
    
    private val outputStream = ByteArrayOutputStream()
    private val standardOut = System.out
    
    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }
    
    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        Console.close()
    }
    
    @Test
    fun `readCarNames returns list of valid car names`() {
        val input = "boji1,boji2,boj3"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        val carNames = inputView.readCarNames()
        assertThat(carNames).containsExactly("boji1", "boji2", "boj3")
    }
    
    @Test
    fun `readCarNames trims whitespace from car names`() {
        val input = "boji1 , bobo2  ,  boji"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        val carNames = inputView.readCarNames()
        assertThat(carNames).containsExactly("boji1", "bobo2", "boji")
    }
    
    @Test
    fun `readCarNames throws exception when no names are provided`() {
        val input = ""
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        assertThatThrownBy { inputView.readCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("At least two car names must be provided its a race!")
    }
    
    @Test
    fun `readCarNames throws exception when only one car name is provided`() {
        val input = "BOJI"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        assertThatThrownBy { inputView.readCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("At least two car names must be provided its a race")
    }
    
    @Test
    fun `readCarNames throws exception when a car name is empty`() {
        val input = "bobo,,bobi"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        assertThatThrownBy { inputView.readCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be empty")
    }
    
    @Test
    fun `readCarNames throws exception when a car name exceeds max length`() {
        val input = "bobo,bobibob,boi"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        assertThatThrownBy { inputView.readCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot have more then 5 characters")
    }
    
    @Test
    fun `readRoundCount returns valid positive integer`() {
        val input = "5"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        val roundCount = inputView.readRoundCount()
        assertThat(roundCount).isEqualTo(5)
    }
    
    @Test
    fun `readRoundCount throws exception for non-integer input`() {
        val input = "abc"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        assertThatThrownBy { inputView.readRoundCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be a valid integer")
    }
    
    @Test
    fun `readRoundCount throws exception for zero`() {
        val input = "0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        assertThatThrownBy { inputView.readRoundCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be positive")
    }
    
    @Test
    fun `readRoundCount throws exception for negative number`() {
        val input = "-5"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()
        
        assertThatThrownBy { inputView.readRoundCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be positive")
    }
 
    @Test
    fun `readRoundCount throws exception for invalid integer`(){
        val input = "5.5"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        val inputView = InputView()

        assertThatThrownBy { inputView.readRoundCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Round count must be a valid integer")
    }
} 