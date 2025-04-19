package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RaceGameTest {

    private lateinit var car1: Car
    private lateinit var car2: Car
    private lateinit var car3: Car
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        car1 = Car("joko")
        car2 = Car("bowo")
        car3 = Car("anis")
        cars = listOf(car1, car2, car3)
    }

    @Test
    @DisplayName("getWinners should identify winners correctly")
    fun returnCarsWithMaxPosition() {
        car1.move()
        car2.move()
        car3.move()
        car1.move()

        val raceGame = RaceGame(cars, 1)
        val winners = raceGame.getWinners()

        assertThat(winners).hasSize(1)
        assertThat(winners).contains(car1.name)
        assertThat(winners).doesNotContain(car2.name, car3.name)
    }

    @Test
    @DisplayName("getWinners should identify multiple winners when tied")
    fun returnMultipleWinnersWhenTied() {
        car1.move()
        car2.move()
        car3.move()
        car1.move()
        car2.move()

        val raceGame = RaceGame(cars, 1)
        val winners = raceGame.getWinners()

        assertThat(winners).hasSize(2)
        assertThat(winners).contains(car1.name, car2.name)
        assertThat(winners).doesNotContain(car3.name)
    }

    @Test
    @DisplayName("Race should run for the specified number of rounds")
    fun raceRunForSpecifiedRounds() {
        val alwaysMoveGame = RaceGame(cars, 3) { 5 }

        alwaysMoveGame.startRound()

        assertThat(alwaysMoveGame.isRaceEnd()).isFalse()

        repeat(4) { alwaysMoveGame.startRound() }

        assertThat(alwaysMoveGame.isRaceEnd()).isTrue()
    }

    @Test
    @DisplayName("Cars should only move when random number is 4 or greater")
    fun moveCarOnlyWhenRandomNumberIsAtLeast4() {
        val neverMoveGame = RaceGame(cars, 1) { 3 }

        neverMoveGame.startRound()
        assertThat(car1.position).isEqualTo(0)
        assertThat(car2.position).isEqualTo(0)
        assertThat(car3.position).isEqualTo(0)

        val alwaysMoveGame = RaceGame(cars, 1) { 4 }

        alwaysMoveGame.startRound()
        assertThat(car1.position).isEqualTo(1)
        assertThat(car2.position).isEqualTo(1)
        assertThat(car3.position).isEqualTo(1)
    }

}