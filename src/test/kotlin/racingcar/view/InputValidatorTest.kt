package racingcar.view

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {

    //자동차명이 5글자 초과 -> 예외 발생
    @Test
    fun `throw exception when car name is longer than 5 chars`(){
        //given : include names that exceed 5 characters
        val invalidNames = listOf("pobi", "jongbinchoi")

        //when & then
        assertThatThrownBy {InputValidator.validateCarNames(invalidNames)}
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name must be between 1 and 5")
            //대소문자 포함 같아야함
    }

    //자동차 이름이 빈 문자열일 경우 예외 던짐
    @Test
    fun `throw exception when car name is empty`(){
        //give : empty car name input
        val invalidNames = listOf("pobi", "")

        //when & then
        assertThatThrownBy { InputValidator.validateCarNames(invalidNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    //시도 횟수가 숫자가 아닌 문자열일 경우 예외 처리
    @Test
    fun `throw exception when round input is not a number`(){
        //given : Non-numeric input
        val input = "five"

        //when & then
        assertThatThrownBy { InputValidator.validateRound(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input must be an integer")
    }
}