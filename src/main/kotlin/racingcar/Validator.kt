package racingcar

class Validator {

    fun validateName(name: String, limit: Int) {
        if (name.length > limit) {
            throw IllegalArgumentException("Car name can be entered up to $limit characters.")
        }
    }

    fun validateStringToInt(stringValue: String): Int {
        return stringValue.toIntOrNull()
            ?: throw IllegalArgumentException("Only numbers can be entered")
    }
}
