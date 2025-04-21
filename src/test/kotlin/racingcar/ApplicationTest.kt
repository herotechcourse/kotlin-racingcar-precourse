package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream

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
        "pobi,,java", // double comma
        ",pobi,java", // starting
        "pobi, java", // space
        "pobi,javaji", // long name
        "pobi", // only 1 name
        "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,x,y,z", // more than 20 names
        "pobi$,java*", // special character
        "pobi,java,pobi", // not unique names -> implement feature, add to README
    ])
    fun `invalid car names test`(input : String) {
        assertThatIllegalArgumentException().isThrownBy { runException(input, "1") }
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
        assertThatNoException().isThrownBy { runException(input, "2") }
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
        assertThatIllegalArgumentException().isThrownBy { runException("car1,car2", input) }
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "1", // min
        "100", // max
        "50", // medium
        "+28" // plus sign
    ])
    fun `valid rounds test`(input : String) {
        assertThatNoException().isThrownBy { runException("car1,car2", input) }
    }

    @ParameterizedTest
    @CsvSource(
        delimiter = ';',
        value = [
        "5;car1 : -----;car2 :;car3 : -----;Winners : car1, car3;$MOVING_FORWARD;$STOP;$MOVING_FORWARD",
        "5;car1 :;car2 : -----;car3 : -----;Winners : car2, car3;$STOP;$MOVING_FORWARD;$MOVING_FORWARD",
        "2;car1 : --;car2 :;car3 : --;Winners : car1, car3;$MOVING_FORWARD;$STOP;$MOVING_FORWARD",
        "1;car1 : -;car2 : -;car3 : -;Winners : car1, car2, car3;$MOVING_FORWARD;$MOVING_FORWARD;$MOVING_FORWARD",
        "1;car1 :;car2 :;car3 :;Winners : car1, car2, car3;$STOP;$STOP;$STOP",
    ])
    fun `test output`(
        rounds : String,
        car1 :String,
        car2 :String,
        car3 :String,
        winners :String,
        move1 :String,
        move2 :String,
        move3 :String
    ) {
        assertRandomNumberInRangeTest(
            {
                run("car1,car2,car3", rounds)
                assertThat(output()).contains("Race Result", car1, car2, car3, winners)
            },
            move1.toInt(),
            move2.toInt(),
            move3.toInt()
        )
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "6",
        "99",
        "0",
    ])
    fun `test number of rounds`(rounds : String) {
        val raceGame = RaceGame(listOf(Car("car1"), Car("car2")), rounds.toInt())

        // redirecting console output
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        raceGame.runRace()
        val output = outputStream.toString()

        val occurrences = output.split("car1 :").size - 1
        assertThat(occurrences).isEqualTo(rounds.toInt())
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
