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
    inputHandle.handleNameEmpty(carList)
    inputHandle.handleNameLength(carList)

    inputHandle.duplicatedName(carList)


    display.showQ2()
    val roundCnt= Console.readLine()
    inputHandle.convertInt(roundCnt)
    println()


    display.showTitle()
    val finalResult=carRace.run(carList,roundCnt)

    display.printWinner(finalResult)


}
