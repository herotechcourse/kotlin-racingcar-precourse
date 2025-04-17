package racingcar.domain

class Car(private val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.isNotBlank()) { "자동차 이름은 필수입니다." }
        require(name.length <= 5) { "자동차 이름은 5자 이하만 가능합니다." }
    }

    fun move(randomNumber: Int) {
        if (randomNumber >= 4) position++
    }

    fun getName(): String = name
}
