package racingcar
import java.util.Random

fun main() {
    var z=0

    class CarName(val name:String){
        var CarMove=""
    }

    println("Please write the car name. Separated by commas. 5letter or less")
    val carName=readLine()?:""
    val list=carName.split(",")

    for(i in 0..list.size-1){
        if(list[i].length>5){
            throw IllegalArgumentException()
        }
    }

    val round=readLine()?.toInt()?:0
    val carList=mutableListOf<CarName>()

    for(i in 0..list.size-1){
        carList.add(CarName(list[i]))
    }

    while(z in 0..round-1) {
        for (j in 0..carList.size - 1) {
            val random = Random()
            val num = random.nextInt(9)
            if (num >= 4) {
                carList[j].CarMove = carList[j].CarMove + "-"
            }
        }

        for (car in carList) {
            println("${car.name} : ${car.CarMove}")
        }
        z++
    }
        val maxMove = carList.maxOf { it.CarMove.length }
        val winners = carList.filter { it.CarMove.length == maxMove }
        println("Winners : " + winners.joinToString(", ") { it.name })
}