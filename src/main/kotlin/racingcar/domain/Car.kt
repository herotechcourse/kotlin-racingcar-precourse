package racingcar.domain

class Car(val name: String){
    init {
        require(name.isNotBlank()){"Car name cannot be Blank"}
        require(name.length<=5){"Car name cannot exceed 5 characters"}
    }


}