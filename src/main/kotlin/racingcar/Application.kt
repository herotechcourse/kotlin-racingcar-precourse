package racingcar

import racingcar.services.RaceResult
import racingcar.services.ConsoleReaderService
import racingcar.services.ReaderService
import racingcar.services.executeRace

fun main() {
    val readerService = ReaderService(ConsoleReaderService())

    val names = readerService.readCarsNames()

    val rounds = readerService.readRounds()

    val result = executeRace(names, rounds)

    result.printAllResults()

    result.printWinners()
}
