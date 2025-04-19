package racingcar.output

data class Car(val name: String, val position: Int) // Later merge

/**
 *  [ Memo ]
 *  1. filter()
 *      Extracts elements that match the condition from a collection (List || Array).
 *      = Returns a new collection containing only selected elements.
 *
 *  2. joinToString()
 *      Merge elements of a List || Collection into a single string.
 *      ex) val names = listOf("jason", "Taekeun", "hong")
 *          val result = names.joinToString(" !! ")
 *          println(result) // jason !! Taekeun !! hong
 */
fun outputFinalWinner(cars: List<Car>): String {
    val maxPos = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPos }
    return "Winners : ${winners.joinToString(", ") { it.name }}"
}