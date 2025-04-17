package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.nio.file.Files.move

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val names = Console.readLine()

    // 5자 이상의 이름이면 오류처리
    if (nameCheck(names)) {
        throw IllegalArgumentException("Car names cannot exceed 5 characters.");
    }

    println("How many rounds will be played?")
    val round = Console.readLine().toInt()

    val game = racingGame(names, round)
    game.playGame()
}

fun nameCheck(name: String) : Boolean {
    return name.split(",")
        .any { it.length > 5}
}

class racingGame(names: String, private val round:Int){
    private val cars : List<Car> = names.split(",").map { Car(it) }
    private var winners = mutableListOf<Car>()

    fun playGame(){
        println()
        println("Race Results")
        repeat(round){
            moveCar();
            println()
        }
        winner()
    }

    fun moveCar(){
        cars.forEach{ car ->
            car.move()
            print("${car.name} : ")
            car.display()
            println()
        }
    }

    fun winner(){
        val maxMoves = cars.maxOf { it.position }
        winners.addAll(cars.filter { it.position == maxMoves })
        print("Winners : ")
        println(winners.joinToString(", ") { it.name })
    }
}

class Car(val name: String){
    var position : Int = 0
        private set

    fun move(){
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            position++;
    }

    fun display(){
        repeat(position){
            print("-")
        }
    }
}
