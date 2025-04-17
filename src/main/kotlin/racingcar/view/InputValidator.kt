package racingcar.view

object InputValidator {

    /**
     * check that all car names are valid
     * each car name must be 1~5
     */
    fun validateCarNames(names: List<String>) {
        names.forEach{name->
            if(name.isBlank() || name.length >5) {
                throw IllegalArgumentException("Car name must be between 1 and 5: $name")
            }
        }
    }

    //Check if it is a number and convert to int
    fun validateRound(input: String): Int{
        return input.toIntOrNull()
        ?: throw IllegalArgumentException("Input must be an integer")
    }
}