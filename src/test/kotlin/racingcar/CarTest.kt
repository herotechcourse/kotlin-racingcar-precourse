import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Car

class CarTest {
    @Test
    fun `car should have a name`() {
        val car = Car("John")
        assertThat(car.name).isEqualTo("John")
    }

    @Test
    fun `should have default distance as empty string`() {
        val car = Car("John")
        assertThat(car.distance).isEqualTo("")
    }

    @Test
    fun `should not move if random generator returns a number less than  4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("John")
                car.move()
                assertThat(car.distance).isEqualTo("")
            }, 2
        )
    }

    @Test
    fun `should move if random generator returns a number 4 or more`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("Ivan")
                car.move()
                assertThat(car.distance).isEqualTo("-")
            }, 5
        )
    }
}
