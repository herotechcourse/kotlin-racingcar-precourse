package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `init with valid name sets name and zero position`() {
        // given
        val name = "pobi"

        // when
        val car = Car(name)

        // then
        assertThat(car.name).isEqualTo(name)
        assertThat(car.getPosition()).isZero()
    }

    @Test
    fun `blank name throws IllegalArgumentException`() {
        // given
        val name = ""

        //when

        //then
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErroMessages.NAME_BLANK)
    }

    @Test
    fun `blank name with only spaces throws IllegalArgumentException`() {
        // given
        val name = "  "

        //when

        //then
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name is missing.")
    }

    @Test
    fun `name longer than five characters throws IllegalArgumentException`() {
        // given
        val name = "exceedFive"

        //when

        //then
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErroMessages.NAME_TOO_LONG)
    }
}
