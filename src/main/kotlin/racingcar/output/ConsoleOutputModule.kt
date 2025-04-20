package racingcar.output

import racingcar.model.Car

/**
 *  [ Responsibility ]
 *  = Divide formatting & Printing for each function.
 *
 *  [ Memo ]
 *  1. map
 *      [f]map is an extensional function in the <List> data structure in Kotlin.
 *      = It transforms each element in the list into a new value,
 *        based on a transformation, and returns a new list with the transformed values.
 *
 *      ex) val numbers = listOf(1, 2, 3, 4)
 *          val multi = numbers.map { it * it }
 *                                  -----------
 *                                  = This is the transformation.
 *
 *          = println(multi) // 1, 4, 9, 16
 *
 *  2. filter()
 *      Extracts elements that match the condition from a collection (List || Array).
 *      = Returns a new collection containing only selected elements.
 *
 *  3. joinToString()
 *      Merge elements of a List || Collection into a single string.
 *      ex) val names = listOf("jason", "Taekeun", "hong")
 *          val result = names.joinToString(" !! ")
 *          println(result) // jason !! Taekeun !! hong
 */
class ConsoleOutputModule : OutputModule {
    private fun formatRoundResult(cars: List<Car>): String {
        val resultLines = cars.map { car ->
            val dashLine = "-".repeat(car.position)
            "${car.name} : $dashLine"
        }
        return resultLines.joinToString("\n")
    }

    override fun outputEachRoundResult(cars: List<Car>) {
        println(formatRoundResult(cars))
    }

    override fun outputFinalWinner(cars: List<Car>): String {
        val maxPos = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPos }
        val result = "Winners : ${winners.joinToString(", ") { it.name }}"
        println(result)
        return result
    }
}