package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.car.AlwaysMoveStrategy
import racingcar.car.Car
import racingcar.car.NeverMoveStrategy

class WinnerTest  {
    private val winner = Winner()
    @Test
    fun `single winner`() {
        // given
        val cars = listOf(
            Car("car1", NeverMoveStrategy()),
            Car("car2", AlwaysMoveStrategy()),
            Car("car3", NeverMoveStrategy())
        )
        // when & then
        cars.forEach{car->
            car.drive()
        }
        val result:String = winner.determineWinners(cars)
        assertEquals("car2",result)
    }

    @Test
    fun `multiple winners`() {
        // given
        val cars = listOf(
            Car("car1", AlwaysMoveStrategy()),
            Car("car2", AlwaysMoveStrategy()),
            Car("car3", NeverMoveStrategy())
        )
        // when & then
        cars.forEach{car->
            car.drive()
        }
        val result:String = winner.determineWinners(cars)
        assertEquals("car1, car2",result)
    }
}