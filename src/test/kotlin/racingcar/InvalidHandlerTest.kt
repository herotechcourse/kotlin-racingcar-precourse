package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InvalidHandlerTest {

    val invalidHandler=InvalidHandler()

    @Test
    @DisplayName("Exception: Car names are not separated by commas")
    fun `handleCommas test`(){
        val input="pobiwonijun"
        assertThrows<IllegalArgumentException> {
            invalidHandler.handleCommas(input)
        }
    }

    @Test
    @DisplayName("Exception: Car name's length exceeds 5 Characters")
    fun `handleNameLength test`(){
        val data= listOf("akrlnkeri","rnkg","car")
        assertThrows<IllegalArgumentException>{
            invalidHandler.handleNameLength(data)
        }
    }

    @Test
    @DisplayName("Exception: Car name doesn't exceed 1 Character")
    fun `handleNameEmpty Test`(){
        val data= listOf("","pobi","woni","jun")
        assertThrows<IllegalArgumentException>{
            invalidHandler.handleNameEmpty(data)
        }
    }

    @Test
    @DisplayName("Exception: Duplicated Name Exist")
    fun `duplicatedName Test` (){
        val data= listOf("pobi","pobi","woni","woni","jun","jun")
        assertThrows<IllegalArgumentException>{
            invalidHandler.duplicatedName(data)
        }
    }

    @Test
    @DisplayName("Exception: Second input can't covert String into Number")
    fun `convertInt Test` (){
        val data="F1"
        assertThrows<IllegalArgumentException>{
            invalidHandler.convertInt(data)
        }
    }

    @Test
    @DisplayName("Exception: Second input must positive number")
    fun `convertPositiveNumber Test` (){
        val data="-1"
        assertThrows<IllegalArgumentException>{
            invalidHandler.convertInt(data)
        }
    }

    @Test
    @DisplayName("Exception: Second input must greater than zero")
    fun `convertNumber Test` (){
        val data="0"
        assertThrows<IllegalArgumentException>{
            invalidHandler.convertInt(data)
        }
    }
}