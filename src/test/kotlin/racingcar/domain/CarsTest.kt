package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.domain.fixture.CarFixture

class CarsTest {
    @Nested
    inner class DuplicationTest {
        @Test
        @DisplayName("[Exception] car names are duplicated")
        fun `test unique exception`() {
            val duplicatedNames = "joo,runa,merry,joo"
            Assertions.assertThatIllegalArgumentException()
                .isThrownBy { Cars.from(duplicatedNames) }
        }

        @Test
        @DisplayName("[Success] car names are unique")
        fun `test unique success`() {
            val uniqueNames = "joo,runa,merri,joon"
            org.junit.jupiter.api.Assertions.assertDoesNotThrow { Cars.from(uniqueNames) }
        }
    }

    @Nested
    inner class CountTest {
        @Test
        @DisplayName("[Exception] car names exceed maximum count")
        fun `test maximum count`() {
            val overCount = "a,b,c,d,e,f,g,h,i,j,k,l,m"
            Assertions.assertThatIllegalArgumentException().isThrownBy { Cars.from(overCount) }
        }

        @Test
        @DisplayName("[Exception] car names must be or exceed minimum count")
        fun `test minimum count`() {
            val lessThanMinimum = "a"
            Assertions.assertThatIllegalArgumentException().isThrownBy { Cars.from(lessThanMinimum) }
        }
    }

    @Nested
    inner class DistanceTest {
        @Test
        @DisplayName("[Success] find the maximum distance")
        fun `test maximum distance`() {
            val fixture = CarFixture()
            val cars = fixture.toDomain()
            for (i: Int in 1..6) cars.moveAll()

            org.junit.jupiter.api.Assertions.assertEquals(fixture.getWon().getDistance(), cars.findMaxDistance())
        }
    }
}