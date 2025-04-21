package racingcar.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {
    
    @Test
    fun `car should be created with valid name`() {

        val name = "chang"

        val car = Car(name)

        assertThat(car.name).isEqualTo(name)
        assertThat(car.getPosition()).isEqualTo(0)
    }
    

}