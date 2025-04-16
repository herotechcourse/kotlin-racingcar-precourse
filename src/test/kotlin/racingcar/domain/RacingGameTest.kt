package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    //자동차 이름 기반 자동차 객체 리스트가 생성되는지 테스트
    fun `create cars from list of names`(){

        //given
        val carNames = listOf("pobi", "woni", "jun")

        //when : Pass car name to the RacingGame class
        val racingGame = RacingGame(carNames)

        assertThat(racingGame.cars).hasSize(carNames.size)
        assertThat(racingGame.cars.map{it.name}).containsExactly("pobi", "woni", "jun")
    }

    @Test
    //moveCar 함수 실행시 모든 자동차가 이동하는지 테스트(단, 랜덤값이 4이상 일경우 가정)
    fun `move all cars forward when random number is greater than or equal to 4`(){
        //give
        val carNames = listOf("pobi", "woni")
        val racingGame = RacingGame(carNames)

        //when : if Random number is 5
        racingGame.moveCars{5}

        //then
        assertThat(racingGame.cars.map{it.position}).containsExactly(1,1)
    }

    @Test
    //가장 멀리 간 자동차 우승자로 반환 테스트
    fun `return winner with maximum position`(){
        //given : if "pobi" moved 2 & "woni" and "jun" moved 3
        val racingGame = RacingGame(listOf("pobi", "woni", "jun"))
        racingGame.cars[0].position = 2
        racingGame.cars[1].position = 3
        racingGame.cars[2].position = 3

        //when
        val winners = racingGame.getWinners()

        //then: winners are "woni" and "jun"
        assertThat(winners).containsExactly("woni", "jun")

    }
}
