package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat


class CheckOutputTest{

    val checkOutput=CheckOutput()
    @Test
    @DisplayName("Success: Multiple Winners Separated by comma")
    fun `checkMultiple output`(){
        assertSimpleTest{
            val result=checkOutput.checkSingle(mutableMapOf("joni" to "---", "woni" to "--", "jun" to "---"))
            assertThat(result).isEqualTo("joni, jun")
        }

    }

    @Test
    @DisplayName("Success: check single output")
    fun `checkSingle output`(){
        assertSimpleTest{
            val result=checkOutput.checkSingle(mutableMapOf("joni" to "--", "woni" to "--", "jun" to "----"))
            assertThat(result).isEqualTo("jun")
        }
    }

    @Test
    @DisplayName("Success: check Single winner")
    fun `checkSingle Winner`(){
        assertSimpleTest{
            val winnerType=checkOutput.checkSingleWin(true,5,5)
            assertThat(winnerType).isEqualTo("first")
        }
    }

    @Test
    @DisplayName("Success: Not a winner")
    fun `notWinner test`(){
       assertSimpleTest{
           val winnerType=checkOutput.checkSingleWin(true,3,5)
           assertThat(winnerType).isEqualTo("noWin")
       }
    }

    @Test
    @DisplayName("Success: Multi winner")
    fun `checkMulti Winner`(){
        assertSimpleTest{
            val winnerType=checkOutput.checkSingleWin(false,5,5)
            assertThat(winnerType).isEqualTo("multi")
        }
    }

    @Test
    @DisplayName("Success: equal to max value")
    fun `checkDistance test`(){
        assertSimpleTest{
            val result=checkOutput.checkDistance(5,5)
            assertTrue(result)
        }
    }

    @Test
    @DisplayName("Success: less than max value")
    fun `checkDistance test2`(){
        assertSimpleTest{
            val result=checkOutput.checkDistance(3,5)
            assertFalse(result)
        }
    }

}