package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Cars

class GameServiceTest {

    private lateinit var gameService: GameService

    @BeforeEach
    fun setUp() {
        gameService = GameService()
    }

    @Test
    @DisplayName("Test creation of Cars object")
    fun createCarsTest() {
        val input = "car1,car2"
        val cars: Cars = gameService.createCars(input)
        assertThat(cars.getCars().size).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = [",car1", "car2,,car3"])
    @DisplayName("Test that invalid input throws exception when creating Cars")
    fun createCars_InvalidInput_ThrowsException(input: String) {
        assertThatThrownBy { gameService.createCars(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
