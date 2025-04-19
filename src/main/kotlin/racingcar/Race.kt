package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(val cars: List<Car>) {
    fun start(){
        cars.forEach{
            var randomNumber = Randoms.pickNumberInRange(0,9)
            if (randomNumber > 4){
                it.move()
            }
        }
        displayCarsPosition()
    }
    fun displayCarsPosition(){
        cars.forEach{
            it.printPosition()
        }
    }

}