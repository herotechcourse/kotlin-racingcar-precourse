package racingcar

import java.util.Random

fun main() {

//Create a name and string space within the class
//Enter the names and put them into each list.
//After checking the length stored in the list, we will create as many class objects as there are and also assign names to the objects inside


    class CarName(val name:String){
        var CarMove=""
    }

    println("Please write the car name. Separated by commas. 5letter or less")
    val carName=readLine()?:""
    val list=carName.split(",")

//At this time, we will determine the length of the name in the list and terminate it with an exception if it exceeds 5 characters.
    for(i in 0..list.size-1){
        if(list[i].length>5){
            println("The car name must be written in at least five letters.")
            System.exit(0)
        }
    }

//It ends after telling me to input the round after exception handling. Should I just group this in object-oriented format and format it?    println(list)//리스트 확인

    //round input
    println("Enter the round.")
    val round=readLine()?.toInt()?:0
    println("라운드 수 : "+round.toString())//라운드 확인


    //Create objects as many as the number of names
//Create and insert objects as many as the number of names into a new list
    val carList=mutableListOf<CarName>()

    for(i in 0..list.size-1){
        carList.add(CarName(list[i]))
    }

//Gamestart
    var z=0
    while(z in 0..round-1) {
        for (j in 0..carList.size - 1) {
            val random = Random()
            val num = random.nextInt(9)
            if (num >= 4) {
                carList[j].CarMove = carList[j].CarMove + "_"
            }
        }
        println((z + 1).toString() + "강")
        for (car in carList) {
            println("${car.name}: ${car.CarMove}")//이거 AI
        }
        z++
    }
//Check the length of CarMove of each object to find a winner. How do you find duplicate winners?
    var Winnername=""
    for(j in 0..carList.size-2){
        if(carList[j+1].CarMove.length>carList[j].CarMove.length){
            Winnername=carList[j+1].name
        }
    }
    println("우승자는"+Winnername)
}
