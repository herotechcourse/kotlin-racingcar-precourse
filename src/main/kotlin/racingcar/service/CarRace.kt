package racingcar.service

import racingcar.model.Cars
/**
 * Represents a racing game involving multiple cars.
 *
 * @property cars The [Cars] collection participating in the race.
 */
class CarRace(private val cars : Cars){

    fun playRaceRound(){
        cars.moveAll()
    }
}
