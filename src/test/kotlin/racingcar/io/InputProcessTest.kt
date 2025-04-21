package racingcar.io

import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayInputStream
import java.io.InputStream
import camp.nextstep.edu.missionutils.Console

class InputProcessTest {

    private lateinit var inputProcess: InputProcess
    private val originalIn = System.`in`

    @BeforeEach
    fun setUp() {
        inputProcess = InputProcess()
        Console.close()
    }

    private fun setInput(input: String) {
        val inputStream: InputStream = ByteArrayInputStream((input + "\n").toByteArray())
        System.setIn(inputStream)
    }


}