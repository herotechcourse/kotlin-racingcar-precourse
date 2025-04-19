package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

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
        fun `test cars count`() {
            val overCount = "a,b,c,d,e,f,g,h,i,j,k,l,m"
            Assertions.assertThatIllegalArgumentException().isThrownBy { Cars.from(overCount) }
        }
    }
}