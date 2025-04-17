package racingcar.application

import racingcar.domain.*
import racingcar.formatter.RaceProgressFormatter
import racingcar.formatter.WinnerFormatter
import racingcar.parser.CarNameParser
import racingcar.parser.RoundParser
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val carNameParser: CarNameParser,
    private val roundParser: RoundParser,
    private val numberGenerator: NumberGenerator,
    private val racePolicy: RacePolicy,
    private val raceProgressFormatter: RaceProgressFormatter,
    private val winnerFormatter: WinnerFormatter
) {

    fun run() {
        val cars = readCars()
        val round = readRound()
        val roundResults = playRace(cars, round)
        printRoundResults(roundResults)
        printWinners(cars)
    }

    private fun readCars(): Cars {
        outputView.printCarNamesPrompt()
        val input = inputView.readCarNames()
        val names = carNameParser.parse(input)
        return Cars.of(names)
    }

    private fun readRound(): Int {
        outputView.printRoundCountPrompt()
        val input = inputView.readNumberOfPlayRound()
        return roundParser.parse(input)
    }

    private fun playRace(cars: Cars, round: Int): List<Cars> {
        val executor = RaceExecutor(numberGenerator, cars, round, racePolicy)
        return executor.execute()
    }

    private fun printRoundResults(roundResults: List<Cars>) {
        outputView.printRaceResultPrompt()
        roundResults
            .map { raceProgressFormatter.format(it) }
            .forEach(outputView::printProgress)
    }

    private fun printWinners(cars: Cars) {
        val winnerMessage = winnerFormatter.format(cars)
        outputView.printWinners(winnerMessage)
    }
}

