package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.services.ConsoleReaderService
import racingcar.services.ReaderService

fun main() {
    val readerService = ReaderService(ConsoleReaderService())
    val names = readerService.readCarsNames()

    val rounds = readerService.readRounds()

    val results = names.associateWith { 0 }.toMutableMap()

    repeat(rounds) {
        for (name in names) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            results[name] = results[name]!! + 1
            if (randomNumber >= 4) {
                results[name] = results[name]!! + 1
            }
        }
    }

    for ((name, score) in results) {
        println("$name : ${"-".repeat(score)}")
    }

    val maxScore = results.values.maxOrNull()!!
    val winners = results.filter { it.value == maxScore }.keys

    println("Winners : ${winners.joinToString(", ")}")

}
