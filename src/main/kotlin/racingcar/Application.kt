package racingcar

import camp.nextstep.edu.missionutils.Console


fun main() {


    val display=Display()
    val carRace=CarRace()

    display.showQ1()
    val str=Console.readLine()
    val inputHandle=InvalidHandler()
    inputHandle.handleCommas(str)
    val carList:List<String> = listOf(*str.split(',').toTypedArray()) //without 5char
    inputHandle.handleNameLength(carList)


    display.showQ2()
    val roundCnt= Console.readLine().toInt()
    println()


    display.showTitle()
    val finalResult=carRace.run(carList,roundCnt)

    display.printWinner(finalResult)


}
