package racingcar

import racingcar.model.Car
import racingcar.io.InputHandler
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputHandler = InputHandler()
    val carNames = inputHandler.getCarNames()
    val rounds = inputHandler.getRounds()
    
    val cars = carNames.map { Car(it) }
    
    var round = 0

    println("Race Results")

    while (round < rounds) {
        for (car in cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move()
            }
        }

        cars.forEach { car ->
            val position = "-".repeat(car.getPosition())
            println("${car.name} : $position")
        }
        println()

        round++
    }

    val maxPosition = cars.maxOf { car -> car.getPosition() }
    val winners = cars.filter { car -> car.getPosition() == maxPosition }
    println("Winners : ${winners.joinToString(", ") { it.name }}")
}
