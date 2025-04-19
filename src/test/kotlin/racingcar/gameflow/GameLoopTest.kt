package racingcar.gameflow

/**
 *  [ Specification for Test ]
 *  1. Has the race been run as many as nRounds repeatedly?
 *  2. Did each car move forward each turn?
 *
 *  [ Memo ]
 *  Almost same as 'MoveCarsTest' but this Test checks flow control.
 *  [f]moveCars() // Is the engine running well?
 *  [f]gameLoop() // How many laps the car goes aroung track?
 */
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

// Always 0-9
fun fakeGenerateRandomNumber(): Int {
    return 9
}

// Always true
fun fakeIsMoveConditionMet(num: Int): Boolean {
    return num >= 4
}

class GameLoopTest {
    @Test
    fun `Test1 - should update race track exactly nRounds times`() {
        val cars = listOf(Car("A"), Car("B"), Car("C"))

        gameLoop(cars, 7, ::fakeGenerateRandomNumber, ::fakeIsMoveConditionMet)

        cars.forEach { car ->
            assertEquals(7, car.position, "Car(= ${car.name}) didn't move correctly")
        }
    }
}