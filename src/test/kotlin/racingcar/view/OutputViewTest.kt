package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import racingcar.model.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private lateinit var outputView: OutputView
    private val originalOut = System.out
    private val outputStream = ByteArrayOutputStream()
    
    @BeforeEach
    fun setUp() {
        outputView = OutputView()
        System.setOut(PrintStream(outputStream))
    }
    
    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
        outputStream.reset()
    }
    
    @Test
    fun `printRoundResult should output car positions correctly`() {
        val cars = listOf(
            Car(1, "pobi", 2),
            Car(2, "woni", 1),
            Car(3, "jun", 0)
        )
        
        outputView.printRoundResult(cars)
        val output = outputStream.toString()
        
        assertThat(output).contains("pobi : --")
        assertThat(output).contains("woni : -")
        assertThat(output).contains("jun : ")
    }
    
    @Test
    fun `printWinners should output winners correctly for single winner`() {
        val winners = listOf(Car(1, "pobi", 5))
        
        outputView.printWinners(winners)
        val output = outputStream.toString().trim()
        
        assertThat(output).isEqualTo("Winners : pobi")
    }
    
    @Test
    fun `printWinners should output winners correctly for multiple winners`() {
        val winners = listOf(
            Car(1, "pobi", 5),
            Car(2, "jun", 5)
        )
        
        outputView.printWinners(winners)
        val output = outputStream.toString().trim()
        
        assertThat(output).isEqualTo("Winners : pobi, jun")
    }
}
