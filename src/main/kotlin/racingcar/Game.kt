package racingcar
import camp.nextstep.edu.missionutils.Randoms;
class Game(
    var cars: List<Car>,
) {
    fun racingGame(round: Int){
        println("Race Results")
        for(i in 1..round){
            gameStart()
            printRoundPosition()
        }
        printWinner(checkWinner())
    }

    private fun gameStart() {
        for(car in cars){
            var num = generateRandomNumber()
            if(checkNumber(num)){
                car.drive()
            }

        }

    }

    private fun printRoundPosition(){
        for(car in cars){
            car.printDrivePosition()
        }
        println()
    }

    private fun generateRandomNumber(): Int{
        return Randoms.pickNumberInRange(0, 9)
    }

    private fun checkNumber(number: Int): Boolean{
        return number>=4;
    }

    fun checkWinner():List<Car>{
        val maxDrive = cars.maxOf{it.driveCount}
        return cars.filter {it.driveCount == maxDrive}
    }
    private fun printWinner(cars:List<Car>){
        var result = ""

        for((index, car) in cars.withIndex()){
            result += car.name
            if(index != cars.lastIndex){
                result += ", "
            }
        }
        println("Winners : $result")
    }




}