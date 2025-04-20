package racingcar.race

import racingcar.output.addLine
import racingcar.repository.Car
import racingcar.repository.CarRepository
import racingcar.repository.ListCarRepository

private val carRepository: CarRepository = ListCarRepository();
private var topScore = 0;
fun race(cars: Array<String>, rounds: Int){
    addLine();
    addLine("Race Results");

    carRepository.addMultipleCars(cars);

    for (i in 1..rounds) {
        val carList: List<Car> = carRepository.getAllCars();
        carList.forEach { car ->
            run {
                val currentCarDistance = car.moveForwardRandomly();
                topScore = topScore.coerceAtLeast(currentCarDistance);
                addLine(car.toString());
            }
        }
        addLine();
    }

    val winners: MutableList<String> = mutableListOf();
    val carList: List<Car> = carRepository.getAllCars();
    carList.forEach {
        car -> run {
            if(car.getDistance() == topScore){
                winners.add(car.getName());
            }
        }
    }
    val result = winners.joinToString(", ");
    addLine("Winners : $result");
}
