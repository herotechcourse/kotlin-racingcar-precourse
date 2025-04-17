package racingcar

import camp.nextstep.edu.missionutils.Randoms


fun main() {

}




object RandomNumController {
    private val startRandomNum = 0
    private val endRandomNum = 9

    fun getRandomNum(): Int {
        return Randoms.pickNumberInRange(startRandomNum, endRandomNum)
    }
}