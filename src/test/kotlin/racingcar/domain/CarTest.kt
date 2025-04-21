package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class CarTest {

    @Test
    fun `car should be created with valid name`() {

        val name = "chang"

        val car = Car(name)

        assertThat(car.name).isEqualTo(name)
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "tungtungtungtungtungtungtungtungtungSahure"])
    fun `car creation should throw exception for invalid name`(invalidName: String) {

        assertThrows<IllegalArgumentException> { Car(invalidName) }
    }

}