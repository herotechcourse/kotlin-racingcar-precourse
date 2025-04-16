package racingcar

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carsStr = readLine() ?: ""
    val carList = carsStr.split(',').map { it.trim() }
    val cars = carList.map { carName -> 
        if (Car.isValidName(carName)) {
            Car(carName)
        } else {
            throw IllegalArgumentException()
        }
    }
    println("$cars")
}
