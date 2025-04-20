package racingcar.input

import racingcar.input.Utils.throwErrorIf

object Rounds {

  fun getInput(input: String): Int {
    val totalRounds = parse(input)
    validate(totalRounds)
    return totalRounds
  }

  private fun parse(input: String): Int {
    return input.trim().toIntOrNull()
        ?: throw IllegalArgumentException("Input failed at getRounds(): input was not a number.")
  }

  private fun validate(totalRounds: Int) {
    throwErrorIf(
        totalRounds > 10,
        "Rounds.validate(): total rounds has a limit of 10 to avoid system overload, please choose a smaller number of rounds.")

    throwErrorIf(totalRounds <= 0, "Rounds.Validate(): '$totalRounds' is not a valid round number.")
  }
}
