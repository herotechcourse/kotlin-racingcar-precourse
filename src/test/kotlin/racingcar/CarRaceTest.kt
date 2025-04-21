package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class CarRaceTest : NsTest(){

    val carRace=CarRace()

    @Test
    fun `show round Results `() {
        assertSimpleTest {
            carRace.run(listOf("pobi", "woni", "jun"), "5")
            assertThat(output()).contains("pobi : ", "woni : ", "jun : ")
        }
    }
    @Test
    @DisplayName("Success: If it is forward direction, output is '-'")
    fun `check direction test`(){
        val direct="MOVING_FORWARD"
        assertSimpleTest {
          carRace.checkDirect(direct)
            assertThat(output()).isEqualTo("-")
        }
    }

    @Test
    @DisplayName("Success: add recent result")
    fun `explainRace test`(){
        val carDirect=mapOf("joni" to "MOVING_FORWARD","woni" to "STOP","jun" to "MOVING_FORWARD")
        val roundResult= mutableMapOf("joni" to "-","woni" to "-","jun" to "--")
        assertSimpleTest{
            val result=carRace.explainRace(carDirect,roundResult)
            assertEquals(result,mutableMapOf("joni" to "--","woni" to "-","jun" to "---"))
        }
    }

    @ParameterizedTest
    @ValueSource(ints=[4,5,6,7,8])
    @DisplayName("Success: if random number is greater than 4, car goes forward")
    fun `if random number is greater than 4, car goes forward`(random: Int){
        val result=carRace.move(random)
        assertThat(result).isEqualTo("MOVING_FORWARD")
    }

    @ParameterizedTest
    @ValueSource(ints=[1,2,3])
    @DisplayName("Success: if random number is less than 4, car stops")
    fun `if random number is less than 4, car stops`(random: Int){
        val result=carRace.move(random)
        assertThat(result).isEqualTo("MOVING_FORWARD")
    }

    override fun runMain() {
        main()
    }



    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}