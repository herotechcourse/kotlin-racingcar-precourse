package racingcar.view
import camp.nextstep.edu.missionutils.Console

interface Display {
    fun getValidNames(): List<String>
}

class ConsoleDisplay : Display {
    private val validator = Validator()
    override fun getValidNames(): List<String> {
    while (true) {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        try {
            validator.validateNames(names)
            return names
        } catch (err: IllegalArgumentException) {
            println(err.message)
        }
    }
}

}