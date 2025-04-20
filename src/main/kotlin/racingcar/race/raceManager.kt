package racingcar.race

import racingcar.output.addLine
import racingcar.car.Car
import racingcar.car.repository.CarRepository
import racingcar.car.repository.ListCarRepository

private val carRepository: CarRepository = ListCarRepository();
private var topScore = 0;
fun race(cars: Array<String>, rounds: Int){
    initialSpacing();
    carRepository.addMultipleCars(cars);
    val carList: List<Car> = carRepository.getAllCars();
    play(rounds, carList);
    declareWinners(carList);
}

private fun initialSpacing(){
    addLine();
    addLine("Race Results");
}

private fun play(rounds: Int, carList: List<Car>){
    for (i in 1..rounds) {
        proceedRound(carList);
        addLine();
    }
}

private fun proceedRound(carList: List<Car>){
    carList.forEach { car -> processCarMovement(car) }
}
private fun processCarMovement(car: Car){
    val currentCarDistance = car.moveForwardRandomly();
    renewTopScore(currentCarDistance);
    addLine(car.toString());
}

private fun renewTopScore(score: Int){
    topScore = topScore.coerceAtLeast(score);
}

private fun declareWinners(carList: List<Car>){
    val winners: MutableList<String> = mutableListOf();
    carList.forEach {
            car -> addWinners(car, winners)
    }
    val result = winners.joinToString(", ");
    addLine("Winners : $result");
}

private fun addWinners(car: Car, winners: MutableList<String>){
    if(car.getDistance() == topScore){
        winners.add(car.getName());
    }
}