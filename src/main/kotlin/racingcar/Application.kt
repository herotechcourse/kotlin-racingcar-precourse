package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
    val carNames = readNames()
    val numRounds = getNumRounds()

    val cars = carNames.map{ Car(it) }

     println("\nRace Results")
     repeat(numRounds){
        cars.forEach{ car -> 
            val number = Randoms.pickNumberInRange(0,9)
            if (number >= 4) car.move()    
        }
        cars.forEach { println(it.display())}
        println()
     }
     val max = cars.maxOf { it.position }
     val winners = cars.filter { it.position == max }.map {it.name}
     println("Winners : ${winners.joinToString(", ")}")
    
}

class Car(val name: String) {
    var position: Int=0
    private set

    fun move() {
        position++
    }
    fun display():String {
        return "$name : ${"-".repeat(position)}"
    }
}

fun readNames() : List<String> {
    println("Enter the names of the cars (comma-seperated): ")
    val input = Console.readLine()
    val names = input.split(",").map {it.trim() }

    if(names.isEmpty()) {
        throw IllegalArgumentException("car names need to be entered")
    }
    names.forEach {
        if(it.isEmpty() || it.length > 5){
            throw IllegalArgumentException("each car names must be 1 to 5 characters long")
        }
    }
    return names;
}

fun getNumRounds() : Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    val count = input.toIntOrNull()
        ?: throw IllegalArgumentException("Number of rounds should be an integer number")

    if(count<=0){
        throw IllegalArgumentException("number of rounds should be bigger than zero")
    }
    return count
}
