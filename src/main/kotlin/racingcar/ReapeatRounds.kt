package racingcar

import racingcar.view.printRoundResult

fun repeatRounds(rounds: Int, cars: List<Car>) {
    repeat(rounds) {
        moveCar(cars)
        printRoundResult(cars)
    }
}

fun moveCar(cars: List<Car>) {
    cars.forEach {
        it.move()
    }
}
