package racingcar.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RoundTest {

    private lateinit var round1: Round
    lateinit var round2: Round
    lateinit var round3: Round
    lateinit var round4: Round
    lateinit var round5: Round

    private lateinit var car1: Car
    private lateinit var car2: Car
    private lateinit var car3: Car

    lateinit var fuel: Fuel

    @BeforeEach
    fun setUp() {
        fuel = GasStation()
        car1 = Car("pobi", fuel = fuel)
        car2 = Car("woni", fuel = fuel)
        car3 = Car("jun", fuel = fuel)

        round1 = Round(1, listOf(car1, car2, car3))
        round2 = Round(2, listOf(car1, car2, car3))
        round3 = Round(3, listOf(car1, car2, car3))
        round4 = Round(4, listOf(car1, car2, car3))
        round5 = Round(5, listOf(car1, car2, car3))
    }

    @Test
    fun roundTest_rightCase() {
        round1.race();
        round2.race();
        round3.race();
        round4.race();
        round5.race();
        assertEquals(car1.getStatus(), 5)
        assertEquals(car2.getStatus(), 5)
        assertEquals(car3.getStatus(), 5)
    }
}