package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    private val util = Util()

    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @DisplayName("Car starts at position 0")
    @Test
    fun carStartsAtZero() {
        assertThat(Car("pobi").currentPosition).isZero()
    }

    @DisplayName("Car position can be incremented")
    @Test
    fun carPositionIncrement() {
        val car = Car("pobi")
        car.currentPosition += 1
        assertThat(car.currentPosition).isEqualTo(1)
    }

    @DisplayName("Name longer than five letters should throw")
    @Test
    fun nameLongerThanFiveThrows() {
        assertThatThrownBy { Cars(listOf("monster")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("cannot exceed 5")
    }

    @DisplayName("Creating Cars with valid names succeeds")
    @Test
    fun createsCarsWithValidNames() {
        val cars = Cars(listOf("pobi", "woni"))
        assertThat(cars.names.map { it.name }).containsExactly("pobi", "woni")
    }

    @DisplayName("Duplicate names are allowed")
    @Test
    fun duplicateNamesAllowed() {
        val cars = Cars(listOf("pobi", "pobi"))
        assertThat(cars.names).hasSize(2)
    }

    @DisplayName("Single winner is returned when one car leads")
    @Test
    fun singleWinner() {
        val cars = Cars(listOf("pobi", "woni"))
        cars.names[0].currentPosition = 2
        cars.names[1].currentPosition = 1

        val winner = Winner(cars)
        assertThat(winner.names).containsExactly("pobi")
    }

    @DisplayName("Multiple winners are returned on tie")
    @Test
    fun multipleWinnersOnTie() {
        val cars = Cars(listOf("pobi", "woni"))
        cars.names.forEach { it.currentPosition = 3 }

        val winner = Winner(cars)
        assertThat(winner.names).containsExactlyInAnyOrder("pobi", "woni")
    }

    @DisplayName("Game advances two rounds and moves cars when random ≥ 4")
    @Test
    fun gameAdvancesRounds() {
        val cars = Cars(listOf("pobi", "woni"))
        val game = Game("2", cars)

        assertRandomNumberInRangeTest(
            {
                game.start()
                // Sequence: pobi 4(→move), woni 3, pobi 3, woni 4(→move)
                assertThat(cars.names[0].currentPosition).isEqualTo(1)
                assertThat(cars.names[1].currentPosition).isEqualTo(1)
            },
            4, 3, 3, 4
        )
    }

    @DisplayName("Split input by comma into exact names")
    @Test
    fun split_returns_exact_names() {
        val result = util.nameSplit("pobi,woni")
        assertThat(result).containsExactly("pobi", "woni")
    }

    @DisplayName("Throw when uppercase character is included in a name")
    @Test
    fun name_with_uppercase_should_throw() {
        assertThatThrownBy { util.nameSplit("PoBi,woni") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("small letters")
    }

    @DisplayName("Throw when a number is included in a name")
    @Test
    fun name_with_number_should_throw() {
        assertThatThrownBy { util.nameSplit("car1,woni") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("Throw when a special character is included in a name")
    @Test
    fun name_with_special_character_should_throw() {
        assertThatThrownBy { util.nameSplit("po@bi,woni") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("Throw when an empty element is provided as a name")
    @Test
    fun empty_name_should_throw() {
        assertThatThrownBy { util.nameSplit("pobi,,woni") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
