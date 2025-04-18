package racingcar

class Car(val name: String, var position: Int = 0) {
    fun move() {
        if (canMove()) position++
    }

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }

    private fun canMove(): Boolean {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4
    }
}
