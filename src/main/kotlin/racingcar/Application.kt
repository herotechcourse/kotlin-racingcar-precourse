package racingcar

fun main() {
    println("Names of the cars (comma-separated):")
    val cars = readln().split(",").map { run {
        require(it.trim().length <= 5) { "Each name should be up to 5 characters"}
        val car = Car(it.trim())
        car
    } }

    println("How many rounds will be played?")
    val rounds = readln().toIntOrNull()
    require(rounds != null) {"The number of rounds should be a valid number"}

    println("\nRace Results")
    for (i in 0..< rounds) {
        cars.forEach{ car ->
            car.move()
            println(car.name + " : " + "-".repeat(car.distance))
        }
        println()
    }

}
