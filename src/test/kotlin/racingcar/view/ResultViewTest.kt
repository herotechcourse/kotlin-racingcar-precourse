package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultViewTest {

    @Test
    fun `자동차 결과 포맷을 문자열로 반환한다`() {
        val car = CarView(name = "pobi", position = 3)
        val result = ResultView.formatCarResult(car)

        assertThat(result).isEqualTo("pobi : ---")
    }
}
