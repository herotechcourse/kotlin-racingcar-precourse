package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car should move when random number is at least 4`(){

        //Given
        var car = Car("pobi")

        //When
        car.move(4)

        //Then
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car should not move if random number is less than 4`(){
        //Given
        val car = Car("pobi")

        //When
        car.move(3)

        //Then
        assertThat(car.position).isEqualTo(0)
    }
}