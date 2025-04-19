package racingcar

fun main() {
    //How to structure the handling when the name is derived?
    val carName=readLine()?:""
    val list=carName.split(",")
    //To add properties, you need to manage them by putting the structure or class in a list.
    // So I have to completely change the structure.


    for(i in 0..list.size-1){
        if(list[i].length>5){
            //종료 어케하노..
            println("이름을 5자 이내로 적어주세요. 프로그램을 종료합니다.")
        }
    }
//If the user inputs a name exceeding 5 characters, it will terminate with an exception.
// Set the comma and enter to have the same function, and when the user inputs a name and presses the comma, it will determine if it exceeds 5 characters and terminate.


    println(list)
    println("라운드를 입력하세요.")
    val round=readLine()?.toInt()
    println(round.toString()+"강")


    var num1=1
    while(num1>0){//round.toInt()

        num1++
    }


//When the round ends, judge the person in front. Check for duplicate winners.
// Game ends.

}
