package racingcar.service.raceexecution

/**
 *  [ Goal ]
 *  = If each car meets movable condition, move one 'position' forward.
 *
 *  Param(1) :  List of Cars
 *  Param(2) :  func1 _ return (Int)
 *  Param(3) :  func2 _ return (Boolean)
 *  Return   :  X
 */
import racingcar.model.Car

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