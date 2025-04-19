package racingcar.output

import racingcar.model.Car

class ConsoleOutputModule : OutputModule {
    // 1. Help function for [f]outputEachRoundResult().
    private fun formatRoundResult(cars: List<Car>): String {
        val resultLines = cars.map { car ->
            val dashLine = "-".repeat(car.position)
            "${car.name} : $dashLine"
        }
        return resultLines.joinToString("\n")
    }

    // 2. Print results of each round
    override fun outputEachRoundResult(cars: List<Car>) {
        println(formatRoundResult(cars))
    }

    // 3. Print results of final winner
    override fun outputFinalWinner(cars: List<Car>): String {
        val maxPos = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPos }
        val result = "Winners : ${winners.joinToString(", ") { it.name }}"
        println(result)
        return result
    }
}