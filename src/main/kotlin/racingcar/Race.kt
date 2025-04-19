package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(val cars: List<Car>,val rounds:Int) {
    fun start(){
        while (!isRaceOver()){
            cars.forEach{
                move(it)
                displayCarsPosition()
                println()
            }
        }
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
    fun move(car:Car){
        var randomNumber = Randoms.pickNumberInRange(0,9)
        if (randomNumber > 4){
            car.position++
        }
    }

}