package racingcar.domain.car

class Position(private var position: Int) {

    fun increase() {
        position++
    }

    fun getPosition(): Int {
        return position
    }
}
