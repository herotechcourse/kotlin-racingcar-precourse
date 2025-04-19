package racingcar.service

object Validator {

    fun validatePositiveRoundCount(input: String) {
        require(input.toInt() > 0) {
            "Rounds should be a positive integer"
        }
    }

    fun validateCarName(carName: String) {
        require(carName.length <= 5 && carName.isNotEmpty()) {
            "Car name should be less than or equal to 5 characters and not empty"
        }
    }
}