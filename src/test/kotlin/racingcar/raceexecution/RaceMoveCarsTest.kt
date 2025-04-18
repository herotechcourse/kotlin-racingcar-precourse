package racingcar.raceexecution

/**
 *  [ Specification for Test ]
 *  1. Check, when one car object meets with condition, if it goes forward well.
 *      -> Check, if Car.position++ works well or not.
 *
 *  2. Check, when all car objects meet with condtion, if they go forward well.
 *      -> Check, if [f]moveCars works well or not.
 */
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

data class Car(val name: String, var position: Int = 0)

// Always 0-9
fun fakeGenerateRandomNumber(): Int {
    return 9
}

// Always true
fun fakeIsMoveConditionMet(num: Int): Boolean {
    return num >= 4
}

// Not yet implemented (RED)
/**
 *  [ Background ]
 *  Function type
 *  = A way to handle a function as a value, assigning it to a variable or passing it as a parameter.
 *
 *  Format: "->"
 */
//fun moveCars(cars: List<Car>,  funcGenerateNum: () -> Int, funCheckMovable: (Int) -> Boolean) {
//    TODO("Not yet implemented");
//}

class MoveCarsTest() {
    @Test
    fun `Test1- should increase one position(Property), if meet condition`() {
        val carObject = Car("A", 2)
        val num = fakeGenerateRandomNumber()

        if (fakeIsMoveConditionMet(num))
            carObject.position++

        assertEquals(3, carObject.position)
    }

    @Test
    fun `Test2- should move all cars forward, if all meet condition`() {
        val cars = listOf(
            Car("A", 0),
            Car("B", 0),
            Car("C", 0)
        )

        moveCars(cars, ::fakeGenerateRandomNumber, ::fakeIsMoveConditionMet)

        cars.forEach { eachCar -> assertEquals(1, eachCar.position) }
    }
}