package racingcar.view

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputViewTest {

    private lateinit var inputView: InputView

    @BeforeEach
    fun setup() {
        inputView = InputView()
    }

    @Test
    fun inputCarNamesTest_rightCase() {
        InputView.InputSource.inputProvider = { "pobi, woni, jun" }
        val inputCarNames = inputView.inputCarNames()
        assertEquals(inputCarNames.size, 3)
        assertEquals(inputCarNames[0].name, "pobi")
        assertEquals(inputCarNames[1].name, "woni")
        assertEquals(inputCarNames[2].name, "jun")
    }

    @Test
    fun inputCarNamesTest_lengthExceed5_throwsException() {
        assertThrows(IllegalArgumentException::class.java) {
            InputView.InputSource.inputProvider = { "pooooobi, wonnnnni, juuuuun" }
            inputView.inputCarNames()
        }
    }

    @Test
    fun inputTryCountTest_rightCase() {
        InputView.InputSource.inputProvider = { "3" }
        val inputTryCount = inputView.inputTryCount()
        assertEquals(inputTryCount.count, 3)
    }

    @Test
    fun inputTryCountTest_notInValidRange_throwsException() {

        assertThrows(IllegalArgumentException::class.java) {
            InputView.InputSource.inputProvider = { "0" }
            inputView.inputTryCount()
        }
        assertThrows(IllegalArgumentException::class.java) {
            InputView.InputSource.inputProvider = { "1001" }
            inputView.inputTryCount()
        }
    }
}
