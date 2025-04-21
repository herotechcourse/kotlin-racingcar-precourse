package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingTest {

    private var max: Int = 0
    private lateinit var racing: Racing

    @BeforeEach
    fun setUp() {
        max = 3
        racing = Racing(max)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5])
    fun `return true max value compare with score`(score: Int) {
        //when
        val isUpdateMax = racing.isNewMaxScore(score)

        //then
        assertTrue(isUpdateMax)
    }
}