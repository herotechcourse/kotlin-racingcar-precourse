package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameTest {
    // validation test
    @Test
    fun `validate car names with valid input`() {
        val game = Game()
        val validNames = listOf("pobi", "crong", "honux")
        game.validateCarNames(validNames)
    }

    @Test
    fun `validate car names with duplicate names should throw exception`() {
        val game = Game()
        val duplicateNames = listOf("pobi", "pobi", "honux")
        assertThrows<IllegalArgumentException> { game.validateCarNames(duplicateNames) }
    }

    @Test
    fun `validate car names with empty name should throw exception`() {
        val game = Game()
        val emptyName = listOf("")
        assertThrows<IllegalArgumentException> { game.validateCarNames(emptyName) }
    }

    @Test
    fun `validate car names with blank name should throw exception`() {
        val game = Game()
        val blankName = listOf(" ")
        assertThrows<IllegalArgumentException> { game.validateCarNames(blankName) }
    }

    @Test
    fun `validate car names with name longer than 5 characters should throw exception`() {
        val game = Game()
        val longName = listOf("pobipobi")
        assertThrows<IllegalArgumentException> { game.validateCarNames(longName) }
    }

    @Test
    fun `validate round with valid input`() {
        val game = Game()
        game.validateRound(5)
    }

    @Test
    fun `validate round with zero should throw exception`() {
        val game = Game()
        assertThrows<IllegalArgumentException> { game.validateRound(0) }
    }

    @Test
    fun `validate round with negative number should throw exception`() {
        val game = Game()
        assertThrows<IllegalArgumentException> { game.validateRound(-1) }
    }

    @Test
    fun `validate round with null should throw exception`() {
        val game = Game()
        assertThrows<IllegalArgumentException> { game.validateRound(null) }
    }

    @Test
    fun `initialize cars with valid names`() {
        val game = Game()
        val carNames = listOf("pobi", "crong")
        game.initializeCars(carNames)
        assertThat(game.getCars()).hasSize(2)
        assertThat(game.getCars()[0].name).isEqualTo("pobi")
        assertThat(game.getCars()[1].name).isEqualTo("crong")
    }
    // winner test
    @Test
    fun `get winners with single winner`() {
        val game = Game()
        val carNames = listOf("pobi", "crong")
        game.initializeCars(carNames)
        game.getCars()[0].position = 3
        game.getCars()[1].position = 1
        assertThat(game.getWinners()).containsExactly("pobi")
    }

    @Test
    fun `get winners with multiple winners`() {
        val game = Game()
        val carNames = listOf("pobi", "crong", "honux")
        game.initializeCars(carNames)
        game.getCars()[0].position = 3
        game.getCars()[1].position = 3
        game.getCars()[2].position = 1
        assertThat(game.getWinners()).containsExactlyInAnyOrder("pobi", "crong")
    }

    @Test
    fun `get winners when all cars have same position`() {
        val game = Game()
        val carNames = listOf("pobi", "crong", "honux")
        game.initializeCars(carNames)
        game.getCars()[0].position = 2
        game.getCars()[1].position = 2
        game.getCars()[2].position = 2
        assertThat(game.getWinners()).containsExactlyInAnyOrder("pobi", "crong", "honux")
    }
}
