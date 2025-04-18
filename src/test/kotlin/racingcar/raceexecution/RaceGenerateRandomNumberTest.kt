package racingcar.raceexecution

/**
 *  [ Specification for Test ]
 *  1. Check, the random number is in the scope.(0 - 9)
 *
 *  [ Memo ]
 *  import org.junit.jupiter.api.RepeatedTest
 *  = Should be repeated a specified number of times.
 */
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Assertions.assertTrue

class GenerateRandomNumberTest {
    @RepeatedTest(100)
    fun `Test1- should return true, if a number between 0 and 9`{
        val generatedNumber = generateRandomNumber()
        assertTrue(generatedNumber >= 0 && generatedNumber <= 9, "generatedNumber($generatedNumber) is out of range")
    }
}