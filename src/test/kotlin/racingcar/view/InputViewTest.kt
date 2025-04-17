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
        val inputCarNames = inputView.inputCarNames("pobi, woni, jun")
        assertEquals(inputCarNames.size, 3)
        assertEquals(inputCarNames[0].name, "pobi")
        assertEquals(inputCarNames[1].name, "woni")
        assertEquals(inputCarNames[2].name, "jun")
    }

    @Test
    fun inputCarNamesTest_lengthExceed5_throwsException() {
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputCarNames("poooobi, wonnnni, juuuuun")
        }
    }

    @Test
    fun inputTryCountTest_rightCase() {
        val inputTryCount = inputView.inputTryCount("3")
        assertEquals(inputTryCount.count, 3)
    }

    @Test
    fun inputTryCountTest_notInValidRange_throwsException() {

        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputTryCount("0")
        }
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputTryCount("1001")
        }
    }
}
