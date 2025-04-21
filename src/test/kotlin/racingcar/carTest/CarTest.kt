package racingcar.carTest

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.models.Car

class CarTest : NsTest() {
    @Test
    fun `createCars should create car instances from names`() {
        val carNames = listOf("lisa", "jim", "tommy")
        val cars = Car.createCars(carNames)

        assertThat(cars).hasSize(3)
        assertThat(cars[0].name).isEqualTo("lisa")
        assertThat(cars[1].name).isEqualTo("jim")
        assertThat(cars[2].name).isEqualTo("tommy")
        assertThat(cars[0].position).isEqualTo(0)
    }

    @Test
    fun `race should move car forward when random number is 4 or greater`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("lisa")
                assertThat(car.position).isEqualTo(0)

                car.race()
                assertThat(car.position).isEqualTo(1)
            },
            7  // Number that will make the car move
        )
    }

    @Test
    fun `race should not move car when random number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("lisa")
                assertThat(car.position).isEqualTo(0)

                car.race()
                assertThat(car.position).isEqualTo(0)
            },
            1  // Number that will not make the car move
        )
    }

    @Test
    fun `printStatus should display car status with dash when position is 1`() {
        val car = Car("lisa", 1)

        assertSimpleTest {
            car.printStatus()
            assertThat(output()).contains("lisa : -")
        }
    }

    @Test
    fun `printStatus should display car status without dashes when position is 0`() {
        val car = Car("lisa", 0)

        assertSimpleTest {
            car.printStatus()
            assertThat(output()).contains("lisa :")
            assertThat(output()).doesNotContain("-")
        }
    }

    @Test
    fun `raceCars should race all cars once`() {
        assertRandomNumberInRangeTest(
            {
                val cars = Car.createCars(listOf("lisa", "jim"))

                Car.raceCars(cars, 1)

                assertThat(output()).contains("Race Results")
                assertThat(output()).contains("lisa : -")
                assertThat(output()).contains("jim :")
            },
            4, // This will make lisa move
            3  // This will make jim stay
        )
    }

    @Test
    fun `raceCars should race all cars for multiple rounds`() {
        assertRandomNumberInRangeTest(
            {
                val cars = Car.createCars(listOf("lisa", "jim"))

                Car.raceCars(cars, 3)

                assertThat(output()).contains("Race Results")

                assertThat(cars[0].position).isEqualTo(2)
                assertThat(cars[1].position).isEqualTo(2)

                assertThat(output()).contains("lisa : -")
                assertThat(output()).contains("lisa : --")
                assertThat(output()).contains("jim : -")
                assertThat(output()).contains("jim : --")
            },
            4, 3,  // Round 1: lisa moves (4), jim doesn't (3)
            3, 4,  // Round 2: lisa doesn't move (3), jim moves (4)
            9, 8   // Round 3: both move (9 and 8)
        )
    }

    @Test
    fun `findMaxPosition should return the highest position`() {
        val cars = listOf(
            Car("lisa", 1),
            Car("jim", 3),
            Car("tommy", 2)
        )

        val maxPosition = Car.findMaxPosition(cars)

        assertThat(maxPosition).isEqualTo(3)
    }

    @Test
    fun `findMaxPosition should return the highest position for a tie`() {
        val cars = listOf(
            Car("lisa", 3),
            Car("jim", 3),
            Car("tommy", 1)
        )

        val maxPosition = Car.findMaxPosition(cars)

        assertThat(maxPosition).isEqualTo(3)
    }

    @Test
    fun `printWinners should print the winner when there is a single winner`() {
        val cars = listOf(
            Car("lisa", 3),
            Car("jim", 2),
            Car("tommy", 1)
        )

        assertSimpleTest {
            Car.printWinners(cars)

            assertThat(output()).contains("Winners : lisa")
        }
    }

    @Test
    fun `printWinners should print all winners when there is a tie`() {
        val cars = listOf(
            Car("lisa", 3),
            Car("jim", 3),
            Car("tommy", 1)
        )

        assertSimpleTest {
            Car.printWinners(cars)

            assertThat(output()).contains("Winners : lisa, jim")
        }
    }


    override fun runMain() {
    }
}
