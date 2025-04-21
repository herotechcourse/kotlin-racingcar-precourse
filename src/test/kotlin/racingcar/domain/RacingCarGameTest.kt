package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class RacingCarGameTest {
    private val racingCarGame = RacingCarGame()

    @Test
    fun `register the cars`() {
        racingCarGame.addCar(Car("si"))
        racingCarGame.addCar(Car("yeon"))
        racingCarGame.addCar(Car("son"))

        assertThat(racingCarGame.allCars.size == 3)
        assertThat(racingCarGame.allCars.map { it.name }).containsExactly("si", "yeon", "son")
    }
}