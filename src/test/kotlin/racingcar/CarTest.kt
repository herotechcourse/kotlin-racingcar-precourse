package racingcar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Car.move act")
class CarTest {
    @Test
    fun `if random number is 4 or more location increases`(){
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `if random number is 3 or less location does not changes`(){
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isZero()
    }
}