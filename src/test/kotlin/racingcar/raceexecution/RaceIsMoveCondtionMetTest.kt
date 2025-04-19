package racingcar.raceexecution

/**
 *  [ Specification for Test ]
 *  1. Check, when param is 4 or more, return true.
 *  2. Check, when param is 3 or less, return false.
 *
 *  [ Logic ]
 *  Check, if random number is same or over 4.
 *      Param   : (int) random number
 *      Return  : (bool) true, false
 *
 *  [ Memo ]
 *  ParameterizedTest & ValueSource: It makes test with various values.
 */
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class IsMoveConditionTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 10, 100, 1000, 10000])
    fun `Test1- should return true when param is 4 or more`(num: Int) {
        assertTrue(isMoveConditionMet(num))
    }

    @ParameterizedTest
    @ValueSource(ints = [-100, -10, 0, 1, 3])
    fun `Test2- should return false when param is less than 4`(num: Int) {
        assertFalse(isMoveConditionMet(num))
    }
}