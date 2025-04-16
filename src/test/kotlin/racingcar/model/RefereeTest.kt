package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RefereeTest {

    private lateinit var car1: Car
    private lateinit var car2: Car
    private lateinit var car3: Car
    private lateinit var fuel: Fuel
    private lateinit var referee: Referee


    @BeforeEach
    fun setUp() {
        fuel = GasStation()
        car1 = Car("pobi", fuel = fuel)
        car2 = Car("woni", fuel = fuel)
        car3 = Car("jun", fuel = fuel)
        referee = Referee(listOf(car1, car2, car3))
    }

    @Test
    fun judgeTest_rightCase() {
        for (i: Int in 1..5) {
            car1.go()
        }
        for (i: Int in 1..3) {
            car2.go()
        }
        car3.go()
        val winners = referee.judge()
        assertEquals(winners.size, 1)
        assertEquals(winners[0].name, "pobi")
    }
}