package racingcar.raceexecution

import racingcar.model.Car
/**
 *  [ Responsibility ]
 *  Executes one turn of the race by updating all cars' positions
 *
 *  [ Memo ]
 *  Internally delegates to moveCars(), which is defined in another file.
 *  Red Name may appear temporarily, cause [f]moveCars() isn't yet merged.
 */
fun raceUpdateTrack (cars: List<Car>,
                    generateNumber: () -> Int,
                    isMovable: (Int) -> Boolean) {
    moveCars(cars, generateNumber, isMovable)
}