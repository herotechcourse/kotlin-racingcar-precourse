package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car {
    private val name: String
    private var moveCount: Int

    constructor(name: String) {
        this.name = name
        this.moveCount = 0
    }

    constructor(name: String, moveCount: Int) {
        this.name = name
        this.moveCount = moveCount
    }

    fun moveIfPossible() {
        val randomNum = Randoms.pickNumberInRange(0, 9)
        if (randomNum >= 4) {
            raiseMoveCount()
        }
    }

    fun raiseMoveCount() {
        moveCount++
    }

    fun getName(): String {
        return name
    }

    fun getMoveCount(): Int {
        return moveCount
    }
}
