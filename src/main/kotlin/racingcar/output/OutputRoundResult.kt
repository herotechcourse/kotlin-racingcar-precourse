package racingcar.output

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
 *      ex) val numbers = listOf{1, 2, 3, 4}
 *          val multi = numbers.map { it * it }
 *                                  -----------
 *                                  = This is the transformation.
 *
 *          = println(multi) // 1, 4, 9, 16
 */
data class Car(val name: String, val position: Int) // Later merge

fun formatRoundResult(cars: List<Car>): String {
    val resultLines = cars.map { car ->
        val dashLine = "-".repeat(car.position)
        "${car.name} : $dashLine"
    }
    return resultLines.joinToString("\n")
}

fun outputEachRoundResult(cars: List<Car>) {
    println(formatRoundResult(cars))
}