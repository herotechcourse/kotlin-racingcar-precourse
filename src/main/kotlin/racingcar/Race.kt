package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Race(val cars: List<Car>,val rounds:Int) {
    fun start(){
        println("Race Results")
        while (!isRaceOver()){
            cars.forEach{
                move(it,generateRandomNumber())
            }
            displayCarsPosition()
            println()
        }
        writeLine(displayWinner())
    }
    fun displayCarsPosition(){
        cars.forEach{
            writeLine(it.getPositionInSting())
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
    fun move(car:Car,randomNumber:Int){
        if (randomNumber >= 4){
            car.position++
        }
    }
    fun displayWinner():String{
        val winners = cars.filter { it.position == rounds }
            .joinToString(", ") { it.name }
        return "Winners : $winners"
    }
    fun generateRandomNumber():Int{
        return Randoms.pickNumberInRange(0,9)
    }
    fun writeLine(line:String){
        println(line)
    }
}