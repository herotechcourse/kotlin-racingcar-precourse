package racingcar.randomNumber

/**
 * @packageName    : racingcar.randomNumber
 * @fileName       : RandomNumber
 * @author         : yong
 * @date           : 4/20/25
 */
interface RandomNumber {
    fun generate(carsCount: Int): List<Int>
}