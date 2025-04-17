package racingcar.gameflow

/**
 *  [ Specification for Test ]
 *  1. Check, Request input from user
 *      1-1. Show guide message for carNames
 *      1-2. Show guide message for Rounds
 *
 *  2. Check, Get input(1): car names
 *      2-1. Call [f]readCarNames().
 *      2-2. Receive and return value from [f]readCarNames().
 *
 *  3. Check, Get input(2): Rounds
 *      3-1. Call [f]readRounds().
 *      3-2. Receive and return value from [f]readRounds().
 *
 *  4. Check, Preparing to connect next step
 *      Check, if GameStartResult is constructed properly.
 *
 *  [ Memo ]
 *  assertTrue      : Check if the function actually executed
 *  assertEquals    : Check if the execution result is the same as expected
 */
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import racingcar.input.InputModule
import racingcar.output.OutputModule

/**
 *  [ Red ]
 *  1. GameManager
 *      Controller that controls input & output at the start of the game.
 *
 *  2. fakeInput
 *      fakeInput implementation for testing purposes only
 *
 *  3. fakeOutput
 *      fakeOutput implementation for testing purposes only
 */
class GameStartTest {

    @Test
    fun `1-1 should show guide message for carNames`() {
        var called = false

        val fakeOutput = object : OutputModule {
            override fun requestCarNames() { called = true }
            override fun requestRounds() {}
        }

        val fakeInput = object : InputModule {
            override fun readCarNames() = "pobi,woni,jun"
            override fun readRounds() = "7"
        }

        val manager = GameManager(fakeInput, fakeOutput)
        manager.start()

        assertTrue(called, "Expected requestCarNames() to be called")
    }

    @Test
    fun `1-2 should show guide message for rounds`() {
        var called = false

        val fakeOutput = object : OutputModule {
            override fun requestCarNames() {}
            override fun requestRounds() { called = true }
        }

        val fakeInput = object : InputModule {
            override fun readCarNames() = "pobi,woni,jun"
            override fun readRounds() = "7"
        }

        val manager = GameManager(fakeInput, fakeOutput)
        manager.start()

        assertTrue(called, "Expected requestRounds() to be called")
    }

    @Test
    fun `2 should call readCarNames() from input module`() {
        var called = false

        val fakeInput = object : InputModule {
            override fun readCarNames(): String {
                called = true
                return "pobi,woni,jun"
            }
            override fun readRounds() = "7"
        }

        val fakeOutput = object : OutputModule {
            override fun requestCarNames() {}
            override fun requestRounds() {}
        }

        val manager = GameManager(fakeInput, fakeOutput)
        val result = manager.start()

        assertTrue(called, "Expected readCarNames() to be called")  // 2-1
        assertEquals("pobi,woni,jun", result.carNames)              // 2-2
    }

    @Test
    fun `3 should call readRounds() from input module`() {
        var called = false

        val fakeInput = object : InputModule {
            override fun readCarNames() = "pobi,woni,jun"
            override fun readRounds(): String {
                called = true
                return "7"
            }
        }

        val fakeOutput = object : OutputModule {
            override fun requestCarNames() {}
            override fun requestRounds() {}
        }

        val manager = GameManager(fakeInput, fakeOutput)
        val result = manager.start()

        assertTrue(called, "Expected readRounds() to be called")    // 3-1
        assertEquals("7", result.rounds)                            // 3-2
    }

    @Test
    fun `4 should construct GameStartResult correctly`() {
        val fakeInput = object : InputModule {
            override fun readCarNames() = "pobi,woni,jun"
            override fun readRounds() = "7"
        }

        val fakeOutput = object : OutputModule {
            override fun requestCarNames() {}
            override fun requestRounds() {}
        }

        val manager = GameManager(fakeInput, fakeOutput)
        val result = manager.start()

        assertEquals("pobi,woni,jun", result.carNames)
        assertEquals("7", result.rounds)
    }
}