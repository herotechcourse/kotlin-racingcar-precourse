package racingcar

fun formatRoundResult(cars: List<Car>): String =
    cars.joinToString("\n") { car ->
        "${car.name} : ${"-".repeat(car.position)}"
    }

fun formatWinners(winners: List<String>): String =
    "Winners : ${winners.joinToString(", ")}"
