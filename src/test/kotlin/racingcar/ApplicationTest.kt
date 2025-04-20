package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `empty input test`() {
        assertSimpleTest {
            val exception1 = assertThrows<IllegalArgumentException> {
                runException("\n", "1")
            }
            assertEquals("No car names provided.", exception1.message)
            val exception2 = assertThrows<IllegalArgumentException> {
                runException("pobi,java", "\n")
            }
            assertEquals("No number provided.", exception2.message)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "pobi,java,", // trailing comma
        "pobi,,java", ",pobi,java",  // empty names, double comma
        "pobi, java", // space
        "pobi,javaji", // long name
        "pobi", // only 1 name
        "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,x,y,z", // more than 20 names
        "pobi$,java*", // special character
        "pobi,java,pobi", // not unique names -> implement feature, add to README
    ])
    fun `invalid car names test`(input : String) {
        assertThatIllegalArgumentException().isThrownBy { InputHandler.validateCarNames(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "BIG,small", // capital letters
        "R2D2,L2D2", // numbers
        "sarah,petra", // 5 chars
        "a,b", // 1 char
        "pobi,java", // 2 cars
        "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20" // 20 cars
    ])
    fun `valid car names test`(input : String) {
        assertThatNoException().isThrownBy { InputHandler.validateCarNames(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "0", // too low
        "101", // too high
        "-50", // minus
        " 1", // space before
        "12 ", // space after
        "1ab", // chars
        "b", // char
    ])
    fun `invalid rounds test`(input : String) {
        assertThatIllegalArgumentException().isThrownBy { InputHandler.validateRounds(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1", // min
        "100", // max
        "50", // medium
        "+28" // plus sign
    ])
    fun `valid rounds test`(input : String) {
        assertThatNoException().isThrownBy { InputHandler.validateRounds(input) }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
