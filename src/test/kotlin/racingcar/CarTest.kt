import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Engine

class CarTest {

    @Test
    @DisplayName("Car needs to change position by movement")
    fun move() {
        // given
        val engine = object : Engine {
            override fun move(): Int = 3
        }
        val car = Car(name = "test", position = 0, engine = engine)

        // when
        car.goForward()

        // then
        val expected = 3
        val actual = car.getPosition()
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Should throw an exception when car name exceeds 5 characters")
    fun carNameExceedsFiveCharactersShouldThrow() {
        val engine = object : Engine {
            override fun move(): Int = 1
        }

        assertThrows<IllegalArgumentException> {
            Car(name = "toolongname", position = 0, engine = engine)
        }
    }

    @Test
    @DisplayName("Should throw an exception when car name is blank")
    fun blankCarNameShouldThrow() {
        val engine = object : Engine {
            override fun move(): Int = 1
        }

        assertThrows<IllegalArgumentException> {
            Car(name = "   ", position = 0, engine = engine)
        }
    }

    @Test
    @DisplayName("Should return the correct name")
    fun carShouldReturnName() {
        val engine = object : Engine {
            override fun move(): Int = 1
        }
        val car = Car(name = "pobi", position = 0, engine = engine)

        assertEquals("pobi", car.getName())
    }
}
