package racingcar

data class Car(val name: String, var position: Int = 0) {
    init {
        require(name.isNotBlank()) { "이름은 빈 문자열일 수 없습니다." }
        require(name.length <= 5)  { "이름은 5자를 초과할 수 없습니다." }
    }
    fun move(randomValue: () -> Int) {
        if (randomValue() >= 4) {
            position++
        }
    }
}