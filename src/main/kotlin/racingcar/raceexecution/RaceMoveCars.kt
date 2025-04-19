package racingcar.raceexecution

/**
 *  [ Goal ]
 *  = If each car meets movable condition, move one 'position' forward.
 *
 *  Param(1) :  List of Cars
 *  Param(2) :  func1 _ return (Int)
 *  Param(3) :  func2 _ return (Boolean)
 *  Return   :  X
 */
data class Car(val name: String, var position: Int = 0)

fun moveCars(cars: List<Car>,
             generateNumber: () -> Int,
             isMovable: (Int) -> Boolean) {
    cars.forEach {
        eachCar ->
        val generatedNum = generateNumber()
        if (isMovable(generatedNum)) {
            eachCar.position++
        }
    }
}