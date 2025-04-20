package racingcar.model


import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.util.RandomsWrapper

class CarTest {

    @BeforeEach
    fun setUp() {
        RandomsWrapper.provider = { 4 }
    }

    @AfterEach
    fun tearDown() {
        RandomsWrapper.provider = { Randoms.pickNumberInRange(0, 9) }
    }

    @Test
    @DisplayName("when RandomsWrapper returns >=4 then position increments by one")
    fun `when RandomsWrapper returns bigger then 4 then position increments by one`() {
        // given
        val car = Car(name = "test")

        // when
        car.tryMove()

        // then
        assertEquals(1, car.position)
    }

    @Test
    @DisplayName("when RandomsWrapper returns <4 then position remains unchanged")
    fun `when RandomsWrapper returns smaller then 4 then position remains unchanged`() {
        // given
        RandomsWrapper.provider = { 3 }
        val car = Car(name = "test")

        // when
        car.tryMove()

        // then
        assertEquals(0, car.position)
    }
}