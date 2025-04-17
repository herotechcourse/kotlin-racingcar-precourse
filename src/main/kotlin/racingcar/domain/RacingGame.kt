package racingcar.domain

import java.util.random.RandomGenerator

class RacingGame(carNames: List<String>) {

    val cars: List<Car> = carNames.map{ Car(it) }

    //@param randomNumberGenerator : give the random number ,Randoms.pickNumberInRange(0, 9)
    fun moveCars(randomNumberGenerator: () -> Int){
        cars.forEach{ car ->
            val randomNumber = randomNumberGenerator()
            car.move(randomNumber)
        }
    }

    //Return a list of the cars that moved the farthest
    //Returns all cars as winners if the cars share the farthest distance
    fun getWinners(): List<String>{
        val maxPosition = cars.maxOf{it.position}
        return cars
            .filter{it.position == maxPosition}
            .map {it.name}
    }

}