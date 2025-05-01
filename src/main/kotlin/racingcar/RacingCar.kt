package racingcar

class RacingCar(val name: String) : Drivable{
    private var distanceTraveled: Int = 0
    private var thresholdToMove: Int = 4
    private var distancePerStep: Int = 1

    override fun tryMove(chance : Int) {
        if (isDrivable(chance)) {
            distanceTraveled += distancePerStep
        }
    }

    private fun isDrivable(chance : Int) : Boolean {
        return chance >= thresholdToMove
    }

    fun printState() {
        println("$name : ${getStateBar()}")
    }

    private fun getStateBar() : String {
        return "-".repeat(distanceTraveled)
    }

    override fun getDistanceTraveled(): Int {
        return distanceTraveled
    }
}