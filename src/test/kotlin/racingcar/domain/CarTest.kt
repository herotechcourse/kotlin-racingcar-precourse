package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import camp.nextstep.edu.missionutils.Randoms

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

    @Test
    fun `car should move forward when random number is 4 or greater`() {

        val car = Car("chang"){8}

        val initialPosition = car.getPosition()

        car.moveIfRandomNumberIsOverFour()

        assertThat(car.getPosition()).isGreaterThan(initialPosition)
    }
    @Test
    fun `car should not move when random number is less than 4`() {

        val car = Car("sahur"){2}

        val initialPosition = car.getPosition()

        car.moveIfRandomNumberIsOverFour()

        assertThat(car.getPosition()).isSameAs(initialPosition)
    }
}