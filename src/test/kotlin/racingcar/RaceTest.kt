package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RaceTest{


    @Test
    fun `isRaceOver returns false when no car reaches target, true when one does`() {

        val carA = Car("CarA").apply { position = 4 }
        val carB = Car("CarB").apply { position = 4 }
        val race = Race(listOf(carA,carB), rounds = 5)
        assertThat(race.isRaceOver()).isFalse()

    }

    @Test
    fun `isRaceOver returns true when one car reaches target`(){
        val carA = Car("CarA").apply { position = 4 }
        val carB = Car("CarB").apply { position = 5 }
        val race = Race(listOf(carA,carB), rounds = 5)
        assertThat(race.isRaceOver()).isTrue()
    }


    @Test
    fun `move should not advance when number less than 4`() {
        val car = Car("CarA").apply { position = 5 }
        val race = Race(listOf(car), rounds = 3)

        race.move(car, 3)
        assertThat(car.position).isEqualTo(5)

    }

    @Test
    fun `should advance when number is 4 or more`(){
        val car = Car("CarA").apply { position = 5 }
        val race = Race(listOf(car), rounds = 3)

        race.move(car, 4)
        assertThat(car.position).isEqualTo(6)
    }

    @Test
    fun `displayWinner returns only winner car`() {
        val carA = Car("carA").apply { position = 4 }
        val carB = Car("carB").apply { position = 3 }
        val race = Race(listOf(carA, carB), rounds = 4)

        var winners = race.displayWinner()
        assertThat(winners).isEqualTo("Winners : carA")

    }

    @Test
    fun `displayWinner returns more than one name if more than one wins`(){
        val carA = Car("carA").apply { position = 4 }
        val carB = Car("carB").apply { position = 4 }
        val race = Race(listOf(carA, carB), rounds = 4)

        var winners = race.displayWinner()
        assertThat(winners).isEqualTo("Winners : carA, carB")
    }

}