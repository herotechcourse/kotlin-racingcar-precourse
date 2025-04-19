package racingcar

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class GameTest {

  //getWinners
  //1. One winner
  @Test
  fun testGetWinners() {
   val car1 =
    Car("car1").apply { position = 1 }
   val car2 =
    Car("car2").apply { position = 2 }

   val game = Game(listOf(car1, car2))
   val winners = game.getWinners()
   assertEquals(listOf(car2), winners)
  }

  //2. Multiple winners
  @Test
  fun testGetWinners_multipleWinners() {
   val car1 =
    Car("car1").apply { position = 1 }
   val car2 =
    Car("car2").apply { position = 2 }
   val car3 =
    Car("car3").apply { position = 2 }

   val game = Game(listOf(car1, car2, car3))
   val winners = game.getWinners()
   assertEquals(listOf(car2, car3), winners)
  }
 }