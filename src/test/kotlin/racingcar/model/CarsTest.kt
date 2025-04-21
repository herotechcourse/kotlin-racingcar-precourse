package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `moveAll should invoke move on all cars`() {
        // Arrange
        val cars = Cars(
            listOf(
                Car(Name("a")),
                Car(Name("b")),
                Car(Name("c"))
            )
        )
        // Act
        cars.moveAll { 9 }

        // Assert
        val expected = setOf(
            LapStatus(Name("a"), Position(1)),
            LapStatus(Name("b"), Position(1)),
            LapStatus(Name("c"), Position(1))
        )
        assertThat(cars.toLapReport().statuses).containsExactlyInAnyOrderElementsOf(expected)

    }

    @Test
    fun `findWinners should return all cars with the max position`() {
        // Arrange
        val car1 = Car(Name("a"), Position(2))
        val car2 = Car(Name("b"), Position(3))
        val car3 = Car(Name("c"), Position(3))

        val cars = Cars(listOf(car1, car2, car3))

        // Act
        val winners = cars.findWinners()

        // Assert
        assertThat(winners).containsExactlyInAnyOrder(Name("b"), Name("c"))
    }

    @Test
    fun `toLapReport should create LapReport with all car statuses`() {
        // Arrange
        val car1 = Car(Name("a"), Position(1))
        val car2 = Car(Name("b"), Position(2))

        val cars = Cars(listOf(car1, car2))

        // Act
        val report = cars.toLapReport()

        // Assert
        assertThat(report.statuses).containsExactlyInAnyOrder(
            LapStatus(Name("a"), Position(1)),
            LapStatus(Name("b"), Position(2))
        )
    }

}
