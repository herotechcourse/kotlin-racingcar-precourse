/**
 *  [ Logic flow ]
 *  1. Test GameManager.start()
 *  2. Make fake Modules (ex) InputModule, OutputModule
 *  3. Check calling status with 'called' variable.
 *  4. Return 'GameStartResult' after test.
 *
 *  [ Why 'private' type? ]
 *  Encapsulation: Only 'GameManager' can control it for safety.
 */
package racingcar.gameflow
import racingcar.input.InputModule
import racingcar.output.OutputModule

data class GameStartResult(val carNames: String, val rounds: String)

class GameManager (private val input: InputModule, private val output: OutputModule)
{
    fun start(): GameStartResult
    {
        output.requestCarNames()
        val carNames = input.readCarNames()

        output.requestRounds()
        val rounds = input.readRounds()

        return GameStartResult(carNames, rounds)
    }
}