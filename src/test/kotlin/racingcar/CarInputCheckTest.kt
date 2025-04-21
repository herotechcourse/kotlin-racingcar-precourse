package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CarInputCheckTest
{
    @Test
    fun `carsFromInput should return a list of car names when input is valid`() {
        val input = "pobi,woni,jun"
        val carInputCheck = CarInputCheck()
        val cars = carInputCheck.carsFromInput(input)
        assertThat(cars).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `carsFromInput should throw IllegalArgumentException when a car name exceeds 5 characters`() {
        val input = "longname,short"
        val carInputCheck = CarInputCheck()
        assertThatThrownBy { carInputCheck.carsFromInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car names should not exceed 5 characters")
    }

    @Test
    fun `carsFromInput should throw IllegalArgumentException when there are duplicate car names`() {
        val input = "pobi,pobi"
        val carInputCheck = CarInputCheck()
        assertThatThrownBy { carInputCheck.carsFromInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Each car should have a unique name")
    }

    @Test
    fun `carsFromInput should throw IllegalArgumentException when no car names are provided`() {
        val input = ""
        val carInputCheck = CarInputCheck()
        assertThatThrownBy { carInputCheck.carsFromInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("At least one car should participate in the race")
    }

    @Test
    fun `carsFromInput should throw IllegalArgumentException when an empty name is provided`() {
        val input = ",,"
        val carInputCheck = CarInputCheck()
        assertThatThrownBy { carInputCheck.carsFromInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("At least one car should participate in the race") // Empty name is also longer than 5 in terms of split logic
    }

    @Test
    fun `carsFromInput should handle single valid car name`() {
        val input = "pobi"
        val carInputCheck = CarInputCheck()
        val cars = carInputCheck.carsFromInput(input)
        assertThat(cars).containsExactly("pobi")
    }

}