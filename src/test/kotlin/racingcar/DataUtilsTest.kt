package racingcar
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class DataUtilsTest {

    @Test
    fun `should set car data correctly`() {
        val input = "car1,car2,car3"
        val result = setCarData(input)
        assertThat(result).isEqualTo(mapOf("car1" to "", "car2" to "", "car3" to ""))
    }
}