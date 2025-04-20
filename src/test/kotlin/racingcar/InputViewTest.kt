package racingcar

import racingcar.view.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayInputStream

class InputViewTest {

    @Test
    @DisplayName("readCarNames should return list of valid car names")
    fun readCarNames_shouldReturnListOfValidCarNames() {
        val input = "pobi,crong,ryan\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val names = InputView.readCarNames()

        assertThat(names).containsExactly("pobi", "crong", "ryan")
    }

}
