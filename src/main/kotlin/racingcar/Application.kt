package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun carRace(carList:List<String>): MutableMap<String,String>{ //Call carRandomNumber pick function

    val carDir = mutableMapOf<String,String>()
    for (car in carList){
        carDir[car] = eachCar()
    }

    return carDir
}

fun eachCar(): String {

    val randomNum= Randoms.pickNumberInRange(0,9)
    return if (randomNum>=4)
    {
        "MOVING_FORWARD"
    }
    else{
        "STOP"
    }
}

fun explainRace(carDirect:Map<String,String>,roundResult:MutableMap<String,String>) : MutableMap<String,String>{
    carDirect.forEach {
            roundResult[it.key]+=forwardDirect(it.value)
    }
    println()
    return roundResult
}

fun forwardDirect(direct: String): String{
    if (direct == "MOVING_FORWARD") {
        return "-"
    }
    return ""
}

fun printWinner(rndRes:MutableMap<String,String>){

    var name=""
    var singleWin=true
    var maxLen=rndRes.maxByOrNull{it.value.length}?.value?.length



    rndRes.forEach{

        val singleCheck= maxLen?.let { it1 -> checkSingleWin(singleWin,it.value.length, it1) }
        if (singleCheck=="first"){
            maxLen=it.value.length
            name+=it.key
            singleWin=false
        }

        if(singleCheck=="multi"){
            maxLen=it.value.length
            name+=", "+it.key
        }

    }
    println()
   print("Winners : $name")
}

fun checkSingleWin(single: Boolean,distance: Int, maxLen:Int): String{
    val chdtance= checkDistance(distance,maxLen)
    if(single && chdtance){
        return "first"
    }


    if(!single&& chdtance){
        return "multi"
    }

    return "noWin"
}

fun checkDistance(distance:Int,maxLen:Int):Boolean{
    return distance==maxLen
}
fun printRound(rndRes:MutableMap<String,String>){

    rndRes.forEach{
        //print name and location
        println(it.key +" : "+ it.value)

    }
}
fun main() {
    // TODO: Implement the program
    println("Enter the names of the cars (comma-separated):")
    val str=Console.readLine()
    //string with comma -> list
    if(!str.contains(",")){
        throw IllegalArgumentException("Cars name should be separated by commas")
    }
    val list:List<String> = listOf(*str.split(',').toTypedArray()) //without 5char

    //if character length > 5 throw IllegalArgumentException
    list.forEach{
        if (it.length>5)
            throw IllegalArgumentException("Car names should not exceed 5 Characters")
    }


    //Enter round
    println("How many rounds will be played?")
    val roundCnt= Console.readLine().toInt()




    println()

    //explainCar호출
    println("Race Results")
    var roundResult= mutableMapOf<String,String>()


    var carDirect=carRace(list)
    carDirect.forEach{
        roundResult[it.key] = ""
    }

    for(i in 0 until roundCnt){

        roundResult=explainRace(carDirect,roundResult)
        printRound(roundResult)
        carDirect=carRace(list)
    }


    printWinner(roundResult)


}
