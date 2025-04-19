package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.utlls.CarFactoring

class CarFactoringTest {

     @Test
     fun testCreateCars() {
         val carList = CarFactoring.createCars(
             listOf("pobi", "woni", "jun"))
         assertThat(carList.map { it.name })
             .containsExactly("pobi", "woni", "jun")
     }
 }