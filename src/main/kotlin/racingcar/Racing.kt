package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing(
    private val cars: List<Car>,
    private val rounds: Int
) {
    fun play(){
        repeat(rounds){
            cars.forEach{car ->
                val num = Randoms.pickNumberInRange(0,9)
                car.move(num)
                println(car.status())
            }
            println()
        }
    }

}