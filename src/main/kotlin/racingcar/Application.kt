package racingcar
import racingcar.model.Car
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }
    val cars = carNames.map { Car(it) }

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()

    val rounds = roundsInput.toInt()
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
