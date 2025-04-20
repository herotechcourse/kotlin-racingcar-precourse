package racingcar.model

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.util.RandomsWrapper

class RaceMovementTest {

    private lateinit var cars: Cars
    private val carNames = listOf("A", "B")

    @BeforeEach
    fun setUp() {
        RandomsWrapper.provider = { 4 }
        cars = Cars(carNames.map { Car(it) })
    }

    @AfterEach
    fun tearDown() {
        RandomsWrapper.provider = { camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) }
    }

    @Test
    @DisplayName("given provider>=4 when play then each car moves every round")
    fun `given provider bigger then 4 when play then each car moves every round`() {
        // given
        val totalRounds = 3
        val race = Race(cars, totalRounds)

        // when
        val history = race.play()

        // then
        assertEquals(totalRounds, history.size)
        history.forEachIndexed { index, snapshot ->
            snapshot.forEach { car ->
                assertEquals(index + 1, car.position)
            }
        }
    }

    @Test
    @DisplayName("given provider<4 when play then cars never move")
    fun `given provider smaller then 4 when play then cars never move`() {
        // given
        RandomsWrapper.provider = { 3 }
        val totalRounds = 3
        val race = Race(cars, totalRounds)

        // when
        val history = race.play()

        // then
        assertEquals(totalRounds, history.size)
        history.forEach { snapshot ->
            snapshot.forEach { car ->
                assertEquals(0, car.position)
            }
        }
    }
}