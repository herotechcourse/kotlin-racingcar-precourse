package racingcar

import kotlin.jvm.JvmOverloads

data class Input (
    val Cars: Array<Car>,
    val TotalRounds: Int
)


data class Car(val name: String, var position: Int = 0) {    
}