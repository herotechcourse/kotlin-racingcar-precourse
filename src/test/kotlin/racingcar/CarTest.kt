package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

 class CarTest {
    @Test
     fun `speed greater than 4`() {
     val car = Car("car1")
    repeat(5) {
     car.forceMove(5)
    }
         assertEquals(5, car.displacement)
   }
     @Test
     fun `speed less than 4`() {
         val car = Car("car1")
         repeat(5) {
             car.forceMove(3)
         }
         assertEquals(0, car.displacement)
     }
 }