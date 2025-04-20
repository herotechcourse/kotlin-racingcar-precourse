package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `moves when move strategy allows`() {
        val car = Car(name = "pobi", position = 0, moveStrategy = AlwaysMovableStrategy())
        car.moveForward()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `does not move when move strategy disallows`() {
        val car = Car(name = "pobi", position = 0, moveStrategy = NeverMovableStrategy())
        car.moveForward()
        assertThat(car.position).isEqualTo(0)
    }

    class AlwaysMovableStrategy : MoveStrategy {
        override fun isMovable(): Boolean = true
    }
    class NeverMovableStrategy : MoveStrategy {
        override fun isMovable(): Boolean = false
    }
}