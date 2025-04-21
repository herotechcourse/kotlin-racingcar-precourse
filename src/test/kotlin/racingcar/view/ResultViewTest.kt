package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultViewTest {

    @Test
    fun car_result_is_returned_as_formatted_string() {
        val car = CarView(name = "pobi", position = 3)
        val result = ResultView.formatCarResult(car)

        assertThat(result).isEqualTo("pobi : ---")
    }
}
