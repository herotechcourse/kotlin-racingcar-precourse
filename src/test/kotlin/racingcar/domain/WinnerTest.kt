package racingcar.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.car.Car

class WinnerTest  {
    private val winner = Winner()
    @Test
    fun `single winner`() {
        // given
        val cars = listOf(
            Car("car1"),
            Car("car2"),
            Car("car3")
        )
        // when & then
        assertRandomNumberInRangeTest(
            {
                cars.forEach{car->
                    car.drive()
                }
                val result:String = winner.determineWinners(cars)
                assertEquals("car2",result)
            },3,4,3

        )
    }

    @Test
    fun `multiple winners`() {
        // given
        val cars = listOf(
            Car("car1"),
            Car("car2"),
            Car("car3")
        )
        // when & then
        assertRandomNumberInRangeTest(
            {
                cars.forEach{car->
                    car.drive()
                }
                val result:String = winner.determineWinners(cars)
                assertEquals("car1, car2",result)
            },4,4,3

        )
    }
}