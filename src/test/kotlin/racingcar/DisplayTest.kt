package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class DisplayTest : NsTest() {
    private val display=Display()

    @Test
    @DisplayName("Success: each round result's display")
    fun `printRound test`(){
        val roundResult= mutableMapOf("pobi" to "-","woni" to "--", "jun" to " ")
        assertSimpleTest {
           display.printRound(roundResult)
            assertThat(output()).contains("pobi : -", "woni : --", "jun :")
        }
    }

    @Test
    @DisplayName("Success: print MultipleWinner")
    fun `printMultipleWinner test`(){
        val last= mutableMapOf("pobi" to "--","woni" to "--", "jun" to " ")
        assertSimpleTest {
            display.printWinner(last)
            assertThat(output()).contains("Winners : pobi, woni")
        }

    }

    @Test
    @DisplayName("Success: print a single winner")
    fun `printSingleWinner Test`(){
        val last= mutableMapOf("pobi" to "---","woni" to "--", "jun" to "----")
        assertSimpleTest {
            display.printWinner(last)
            assertThat(output()).contains("Winners : jun")
        }
    }

    @Test
    @DisplayName("Success: show question1")
    fun `display the prompt 'Enter the names of the cars (comma-separated)'`(){
        assertSimpleTest{
            display.showQ1()
            assertThat(output()).isEqualTo("Enter the names of the cars (comma-separated):")
        }
    }


    @Test
    @DisplayName("Success: show question2")
    fun `display the prompt 'How many rounds will be played?'`(){
        assertSimpleTest{
            display.showQ2()
            assertThat(output()).isEqualTo("How many rounds will be played?")
        }
    }

    @Test
    @DisplayName("Success: show title")
    fun `display the prompt 'Race Results'`(){
        assertSimpleTest{
            display.showTitle()
            assertThat(output()).isEqualTo("Race Results")
        }
    }

    override fun runMain() {
        main()
    }
}