package racingcar.backend.domain

class Race(
    val car: Car,
    val position: MutableList<String> = mutableListOf(),
) {
}