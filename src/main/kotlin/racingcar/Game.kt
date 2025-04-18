package racingcar

data class Input (
    val Cars: Array<Car>,
    val TotalRounds: Int
)


data class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length <= 5) { "name cannot exceed 5 characters: $name" }
    }
}