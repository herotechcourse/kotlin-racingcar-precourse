package racingcar

import racingcar.services.ConsoleReaderService
import racingcar.services.ReaderService
import racingcar.services.executeRace

fun main() {
    val readerService = ReaderService(ConsoleReaderService())
    val names = readerService.readCarsNames()

    val rounds = readerService.readRounds()

    val results = executeRace(names, rounds)

    for ((name, score) in results) {
        println("$name : ${"-".repeat(score)}")
    }

    val maxScore = results.values.maxOrNull()!!
    val winners = results.filter { it.value == maxScore }.keys

    println("Winners : ${winners.joinToString(", ")}")

}
