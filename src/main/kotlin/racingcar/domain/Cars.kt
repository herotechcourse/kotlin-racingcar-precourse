package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Cars(val cars: List<Car>) {
    fun moveAll() {
        cars.forEach { car ->
            car.moveIfOverThreshold(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))
        }
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 9

        fun from(names: List<String>): Cars {
            val carList = names.map { Car(it) }
            return Cars(carList)
        }
    }
}