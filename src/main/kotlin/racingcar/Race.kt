package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Race (val carString: String, val round: Int){
    private val cars: List<Car>

    init{
        val inputCarNames = carString.split(",")
        
        if(inputCarNames.any { it.length<1 || it.length > 5}){
            throw IllegalArgumentException("The name of the car must be 5 characters or less.")
        }

        if(round<1){
            throw IllegalArgumentException("The number of rounds must be greater than 0.")
        }

        cars = inputCarNames.map { Car(it) }
    }

    fun printStatus(): String {
        return "Cars: ${cars.joinToString(",") { it.name }}\n" +
                "Distance: ${cars.joinToString(",") { it.distance.toString() }}\n"+
                "Round: ${round}\n"
    }

    fun getRandNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun moveCars() {
        for (car in cars) {
            if (getRandNumber() >= 4) {
                car.moveForward()
            }
        }
    }

    fun printCars(){
        for(car in cars){
            println("${car.name} : ${"-".repeat(car.distance)}")
        }
        println()
    }

    fun getWinners(): List<String> {
        val maxDistance = cars.maxOf { it.distance }
        return cars.filter { it.distance == maxDistance }.map{it.name}
        //by using filter: filter the cars that have the same distance as the maximum distance
        //by using map: get a list of car name string lists from the filtered cars
    }

    fun playRound(){
        println("Race Results")
        for(i in 0 until round){
            moveCars()
            printCars()
        }

        val winners:List<String> = getWinners()
        println("Winners : ${winners.joinToString(",") { it }}")
    }
}