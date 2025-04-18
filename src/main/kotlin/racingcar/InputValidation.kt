package racingcar

import camp.nextstep.edu.missionutils.Console


fun checkCarInput(data: String) {
    require(data.contains(",")) { "Car names should be separated by comma" }
}

fun checkCarData(data: Map<String, Int>) {
    require(data.all { it.key.isNotBlank() }) { "Car name should not be blank" }
    require(data.all { it.key.length <= 5 }) { "Car name should not be longer than 5 characters" }
}

fun readCars(): Map<String, Int> {
    println("Enter the names of the cars (comma-separated):")
    val data = Console.readLine()
    println("data: $data")
    checkCarInput(data)
    val cars = data.split(",").associateWith { 0 }
    checkCarData((cars))
    return cars
}
