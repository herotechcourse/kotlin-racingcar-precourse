/**
 * Car class
 */

package racingcar

class Car(val name: String, val lane: Lane) {
    var position: Int = 0
        private set

    fun getReady() {
        this.position = 0
    }

    private fun moveForward() {
        this.position++
    }

    fun attemptMoveForward() {
        if (this.lane.canMoveForward()) {
            this.moveForward()
        }
    }

    fun raceStatus() : String {
        return "${this.name} : ${"-".repeat(this.position)}"
    }
}
