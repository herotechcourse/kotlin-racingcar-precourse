package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(val cars: List<Car>,val rounds:Int) {
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
    fun isRaceOver():Boolean{
        var counter = 0;
        cars.forEach{
            if (it.position == rounds){
                counter++
            }
        }
        return counter >= 1
    }

}