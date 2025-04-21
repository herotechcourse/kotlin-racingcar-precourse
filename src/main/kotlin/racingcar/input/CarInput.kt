package racingcar.input

object CarInput {

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated): ")
        val carInput = readln()
        return carInput.split(",")
    }
}