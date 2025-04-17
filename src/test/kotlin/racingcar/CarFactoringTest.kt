package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

 class CarFactoringTest {

     @Test
     fun testCreateCars() {
         val carList = CarFactoring.createCars(
             listOf("pobi", "woni", "jun"))
         assertThat(carList.map { it.name })
             .containsExactly("pobi", "woni", "jun")
     }
 }