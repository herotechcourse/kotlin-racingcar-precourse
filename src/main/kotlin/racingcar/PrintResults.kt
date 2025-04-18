package racingcar

fun printRound(car: MutableMap.MutableEntry<String, String>) {
    println("${car.key} : ${car.value}")
}

fun printWinners(cars: MutableMap<String, String>) {
    val winners = getWinners(cars)
    println("Winners : ${winners.keys.joinToString(", ")}")
}