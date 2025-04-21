package racingcar

import racingcar.services.RaceResult
import racingcar.services.ConsoleReaderService
import racingcar.services.ReaderService
import racingcar.services.executeRace

fun main() {
    val readerService = ReaderService(ConsoleReaderService())
    val names = readerService.readCarsNames()

    val rounds = readerService.readRounds()

    val results = executeRace(names, rounds)

    val raceResult = RaceResult(results)

    raceResult.printAllResults()

    raceResult.printWinners()
}
