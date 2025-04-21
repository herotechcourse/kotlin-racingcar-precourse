package racingcar.view

object Validator {
    fun validateCarNames(names: List<String>) {
        require(names.isNotEmpty()) { "Car names cannot be empty" }
        names.forEach {
            require(it.isNotBlank()) { "Car name cannot be blank" }
            require(it.length <= 5) { "Car name cannot be longer than 5 characters" }
        }
        require(names.distinct().size == names.size) { "Each Car name must be unique" }
    }
}
