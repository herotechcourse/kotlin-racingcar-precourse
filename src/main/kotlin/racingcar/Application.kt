package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // Solicitar nombres de los autos
    println("Please enter the name of the cars (they must be separated with a comma and max. length 5 characters each):")
    val input = Console.readLine() ?: throw IllegalArgumentException("No car name entered.")

    // Dividir los nombres y verificar que no excedan los 5 caracteres
    val carNames = input.split(",").map { it.trim() }
    carNames.forEach {
        if (it.length > 5) throw IllegalArgumentException("Car name '$it' exceeds 5 characters.")
    }

    // Solicitar número de rondas
    println("Please enter the number of rounds:")
    val roundsInput = Console.readLine() ?: throw IllegalArgumentException("Number of rounds was not provided.")
    val rounds = roundsInput.toIntOrNull() ?: throw IllegalArgumentException("Invalid number of rounds.")

    // Inicializar las posiciones de los autos
    val carPositions = mutableMapOf<String, Int>()
    carNames.forEach { carPositions[it] = 0 }

    // Ejecutar las rondas
    repeat(rounds) {
        println("Round ${it + 1}:")
        carNames.forEach { car ->
            // Si el número aleatorio es >= 4, el auto avanza
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carPositions[car] = carPositions[car]!! + 1
            }
            // Mostrar la posición actual del auto
            println("$car : ${"-".repeat(carPositions[car]!!)}")
        }
        println()
    }

    // Determinar los ganadores
    val maxPosition = carPositions.values.maxOrNull() ?: throw IllegalStateException("No cars found.")
    val winners = carPositions.filter { it.value == maxPosition }.keys

    // Mostrar los ganadores
    println("Winner(s): ${winners.joinToString(", ")}")
}
