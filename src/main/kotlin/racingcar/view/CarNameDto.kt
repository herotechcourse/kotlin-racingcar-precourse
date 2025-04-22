package racingcar.view

data class CarNameDto(val name: String) {
    init {
        require(name.length <= 5) { "Car name must be between 1 and 5" }
    }
}