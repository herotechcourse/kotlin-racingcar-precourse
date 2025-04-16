package racingcar

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carsStr = readLine() ?: ""
    val carList = carsStr.split(',').map { it.trim() }
    val cars = carList.mapNotNull { carName -> 
        if (Car.isValidName(carName)) {
            Car(carName)
        } else {
            println("error")
            null
        }
    }
    println("$cars")
}
