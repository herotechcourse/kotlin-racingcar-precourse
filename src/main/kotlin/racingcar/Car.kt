package racingcar

/**
 * @packageName    : racingcar
 * @fileName       : Car
 * @author         : yong
 * @date           : 4/16/25
 * @description    :
 */


class Car(private val name: String) {
    private var position: Int = 0

    fun move(num: Int) {
        if (num >= 4 && num <= 9) {
            position++
        }
    }

    fun getPositionBar(): String {
        return "-".repeat(position)
    }
}