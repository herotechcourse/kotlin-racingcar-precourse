package racingcar
import camp.nextstep.edu.missionutils.Console


fun main() {
    val cars = mutableListOf<Car>()

    println("Enter the names of the cars (comma-separated): ")
    val carNames = Console.readLine().split(",");

    for(name in carNames){
        cars.add(Car(name));
    }

    val game = Game(cars)
    println("How many rounds will be played?")
    val round = Integer.parseInt(Console.readLine())
    game.racingGame(round)












}
