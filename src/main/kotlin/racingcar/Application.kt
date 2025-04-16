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

    println("How many rounds will be played?")
    val roundStr=readLine()
    val rounds=roundStr?.toIntOrNull()
    if(rounds==null)
    {
        throw IllegalArgumentException()
    }
    
    val race=Race(rounds,cars)
    race.run()
    race.displayWinners()

}
