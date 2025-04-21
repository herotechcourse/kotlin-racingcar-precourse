package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarDetailedTest : NsTest() {

    @Test
    fun `car names validation test`() {
        assertSimpleTest {
            // Test valid names
            val validCars = validateCarNames("car1,car2,car3")
            assertThat(validCars).hasSize(3)
            assertThat(validCars[0].name).isEqualTo("car1")

            // Test name too long
            assertThrows<IllegalArgumentException> {
                validateCarNames("car1,toolongname,car3")
            }

            // Test empty name
            assertThrows<IllegalArgumentException> {
                validateCarNames("car1,,car3")
            }
        }
    }

    @Test
    fun `rounds validation test`() {
        assertSimpleTest {
            // Test valid rounds
            val validRounds = validateRounds("3")
            assertThat(validRounds).isEqualTo(3)

            // Test invalid rounds
            assertThrows<IllegalArgumentException> { validateRounds("0") }
            assertThrows<IllegalArgumentException> { validateRounds("-1") }
            assertThrows<IllegalArgumentException> { validateRounds("abc") }
        }
    }

    @Test
    fun `car movement test`() {
        // Test car moves when random number >= 4
        assertRandomNumberInRangeTest(
            {
                val car = Car("car1", 0)
                val moved = if (shouldMoveForward()) moveForward(car) else car
                assertThat(moved.position).isEqualTo(1)
            },
            MOVING_FORWARD  // Use 4 from companion object
        )

        // Test car doesn't move when random number < 4
        assertRandomNumberInRangeTest(
            {
                val car = Car("car1", 0)
                val moved = if (shouldMoveForward()) moveForward(car) else car
                assertThat(moved.position).isEqualTo(0)
            },
            STOP  // Use 3 from companion object
        )
    }

    @Test
    fun `round simulation test`() {
        // Test one round with some cars moving and others not
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(
                    Car("car1", 0),
                    Car("car2", 0)
                )
                val result = simulateRound(cars)
                assertThat(result[0].position).isEqualTo(1) // car1 moves
                assertThat(result[1].position).isEqualTo(0) // car2 doesn't move
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `winner determination test`() {
        assertSimpleTest {
            // Single winner test
            val singleWinnerResults = listOf(
                listOf(Car("car1", 0), Car("car2", 0)),
                listOf(Car("car1", 2), Car("car2", 1))
            )
            val singleWinner = determineWinners(singleWinnerResults)
            assertThat(singleWinner).hasSize(1)
            assertThat(singleWinner[0].name).isEqualTo("car1")

            // Tie test
            val tieResults = listOf(
                listOf(Car("car1", 0), Car("car2", 0)),
                listOf(Car("car1", 2), Car("car2", 2))
            )
            val tiedWinners = determineWinners(tieResults)
            assertThat(tiedWinners).hasSize(2)
            assertThat(tiedWinners.map { it.name }).containsExactlyInAnyOrder("car1", "car2")
        }
    }

    @Test
    fun `full race test`() {
        assertRandomNumberInRangeTest(
            {
                run("car1,car2,car3", "2")
                val output = output()

                // Check car1 moved in both rounds
                assertThat(output).contains("car1 : -")
                assertThat(output).contains("car1 : --")

                // Check car2 moved only in second round
                assertThat(output).contains("car2 : ")
                assertThat(output).contains("car2 : -")

                // Check car3 never moved
                assertThat(output).contains("car3 : ")

                // Check winner is car1
                assertThat(output).contains("Winners : car1")
            },
            MOVING_FORWARD, STOP, STOP,  // Round 1
            MOVING_FORWARD, MOVING_FORWARD, STOP  // Round 2
        )
    }

    @Test
    fun `multiple winners test`() {
        assertRandomNumberInRangeTest(
            {
                run("car1,car2", "1")
                val output = output()

                // Both cars move
                assertThat(output).contains("car1 : -")
                assertThat(output).contains("car2 : -")

                // Both are winners
                assertThat(output).contains("Winners : car1, car2")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    override fun runMain() {
        Application.main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}