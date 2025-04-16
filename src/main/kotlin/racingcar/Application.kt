package racingcar

import racingcar.movement.CarAdapter
import racingcar.model.Car
//import racingcar.movement.Car

fun main() {
    println("Racing Car App Starting...")

    // Initialized for testing purposes
    val car = Car(name = "audi", position = 0)

    // Create a CarAdapter for the car
    val carAdapter = CarAdapter(car)

    // Simulate 5 rounds of movement
    repeat(5) { round ->
        println("Round ${round + 1}:")
        carAdapter.updatePosition()
        println("${car.name}: ${"-".repeat(car.position)}")
    }

    // Final position print
    println("Final Position of ${car.name}: ${"-".repeat(car.position)}")
}