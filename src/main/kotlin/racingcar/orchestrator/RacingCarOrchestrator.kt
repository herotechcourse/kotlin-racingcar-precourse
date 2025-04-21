package racingcar.orchestrator

import racingcar.input.InputReader
import racingcar.process.RaceExecutor
import racingcar.output.RaceResultRenderer

class RacingCarOrchestrator {

    fun carRace(){
        val inputReader = InputReader()
        val carNames = inputReader.readAndGetCarNames()
        val rounds = inputReader.readAndGetRounds()

        val raceExecutor = RaceExecutor()
        val raceResults = raceExecutor.executeRaceAndGetResult(carNames, rounds)

        val raceResultRenderer = RaceResultRenderer()
        val perRound = raceResultRenderer.calculatePerRoundScores(raceResults, rounds)
        val renderedRounds = raceResultRenderer.renderPerRoundScores(perRound)
        println("\nRace Results")
        println(renderedRounds)

        val finalScores = raceResultRenderer.calculateRaceScores(raceResults, rounds)
        val determineWinner = raceResultRenderer.determineWinners(finalScores)
        val finalWinners = raceResultRenderer.renderFinalWinners(determineWinner)

        println(finalWinners)
    }
}