package racingcar.view

data class TryCountDto(val count: Int) {
    init {
        require(count in 1..1000) { "Try Count must be between 1 and 1000" }
    }
}