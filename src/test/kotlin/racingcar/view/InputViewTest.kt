package racingcar.view

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputViewTest {

    lateinit var inputView: InputView

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
}