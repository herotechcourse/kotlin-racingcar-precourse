package racingcar

fun main() {
    val application = Application()
    val isSuccess = application.run()

    if (!isSuccess) return // terminate
}

class Application {
     fun run(): Boolean {
         return try {
             val inputHandler = InputHandler()
             val inputs = inputHandler.getInputs()

             Race(inputs).run()

             true
         } catch (error: Exception) {
             println(error.message)

             false
         }
    }
}

