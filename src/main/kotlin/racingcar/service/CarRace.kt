package racingcar.service

import racingcar.model.Cars

class CarRace(private val cars : Cars){
    fun play(){
        cars.moveAll()
    }
}