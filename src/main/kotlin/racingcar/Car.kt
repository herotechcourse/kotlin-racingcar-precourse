package racingcar

class Car (
    var name: String
    ){
    var driveCount: Int =0
    init{
        if(name.length >= 5){
            throw IllegalArgumentException("name length must be under 5")
        }
    }
    fun drive(){
        this.driveCount++
    }

    fun printDrivePosition(){
        println("$name : ${"-".repeat(driveCount)}")
    }

}