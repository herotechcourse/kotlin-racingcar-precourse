package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * Car class
 *
 * @constructor primary constructor to initialize the carName
 * @param carName: read-only property (val)
 * @property _moveCount: mutable private property (var)
 * @property moveCount: exposes _moveCount as read-only public property
 * via a getter
 *
 * @see move: increments _moveCount based on random numbers
 * @see printProgress: prints carName and _moveCount in a specific syntax
 */
class Car(val carName: String) {
    private var _moveCount: Int = 0
    val moveCount: Int
        get() = _moveCount

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            _moveCount++
    }

    fun printProgress() {
        print("$carName : ")
        for (i in 1.._moveCount)
            print("-")
        println()
    }
}