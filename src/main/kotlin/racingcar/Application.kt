package racingcar
import camp.nextstep.edu.missionutils.Console

class Game{

  fun start() {
    println("Enter car names (separated by commas):")
    val carInput = Console.readLine()
    val carNames = carInput.split(",").map { it.trim() }
    validateCarNames(carNames)
    
    println("Enter the number of rounds:")
    val roundInput = Console.readLine().toIntOrNull()
    validateRound(roundInput)
    val round = roundInput!!
  }

  fun validateCarNames(carNames: List<String>) {
    if (carNames.any { it.isBlank() || it.length > 5 }) {
        throw IllegalArgumentException("Car names cannot be blank and must not exceed 5 characters.")
    }
    if (carNames.distinct().size != carNames.size) {
        throw IllegalArgumentException("Car names must be unique.")
    }
  }

  fun validateRound(round: Int?) {
    if (round == null || round <= 0) {
        throw IllegalArgumentException("Number of rounds must be a valid and positive number.")
    }
  } 
}

fun main() {
  Game().start()
}
