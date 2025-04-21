package racingcar.io


import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputProcessTest {
    
    private lateinit var outputProcess: OutputProcess
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()
    
    @BeforeEach
    fun setUp() {
        outputProcess = OutputProcess()
        System.setOut(PrintStream(outputStreamCaptor))
    }
    
    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }
    

}