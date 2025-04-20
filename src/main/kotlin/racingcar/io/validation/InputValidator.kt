package racingcar.io.validation

object InputValidator {
    private const val MAX_NAME_LENGTH = 5
    private const val MIN_NAME_LENGTH = 1
    private const val MIN_CARS = 2
    private const val MIN_ROUNDS = 1

    // ######################################## VALIDATOR FUNCTIONS ########################################
    fun validateCarNames(carNames: String): List<String>{
        validateNotEmpty(carNames, "Car names are required")
        val cars = validateCharLengthAndReturnCars(carNames, "Car names must be in the range $MIN_NAME_LENGTH-$MAX_NAME_LENGTH(inclusive) characters")
        validateCarsCount(cars, "At least $MIN_CARS cars are needed to race")
        validateDuplicateNames(cars, "Car names must be unique")
        return cars
    }

    fun validateNumberOfRounds(numberOfRounds: String): Int{
        validateNotEmpty(numberOfRounds, "The number of rounds are required")
        val rounds = validateNumber(numberOfRounds, "The number of rounds must be a number")
        validateMinimumRounds(rounds, "The number of rounds must be positive and at least be $MIN_ROUNDS round long")
        return rounds
    }

    // ######################################## HELPER FUNCTIONS ########################################
    private fun validateNotEmpty(input: String, errorMessage: String){
        if(input == ""){
            throw IllegalArgumentException(errorMessage)
        }
    }

    private fun validateCharLengthAndReturnCars(carNames: String, errorMessage: String): List<String>{
        val cars = carNames.split(",").map { car -> car.trim() }
        if(cars.any { carName -> carName.length < MIN_NAME_LENGTH || carName.length > MAX_NAME_LENGTH }){
            throw IllegalArgumentException(errorMessage)
        }
        return cars
    }

    private fun validateCarsCount(cars: List<String>, errorMessage: String){
        val carsCount = cars.size
        validateMinimumValue(carsCount, MIN_CARS, errorMessage)
    }

    private fun validateMinimumValue(value: Int, minimumVal: Int, errorMessage: String){
        if(value < minimumVal){
            throw IllegalArgumentException(errorMessage)
        }
    }

    private fun validateDuplicateNames(cars: List<String>, errorMessage: String){
        val carsSet = cars.toSet()
        if(carsSet.size != cars.size){
            throw IllegalArgumentException(errorMessage)
        }
    }

    private fun validateNumber(input: String, errorMessage: String): Int{
        return input.toIntOrNull() ?: throw IllegalArgumentException(errorMessage)
    }

    private fun validateMinimumRounds(rounds: Int, errorMessage: String){
        validateMinimumValue(rounds, MIN_ROUNDS, errorMessage)
    }



}