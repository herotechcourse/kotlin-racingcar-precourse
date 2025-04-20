package racingcar.service

import racingcar.domain.Cars

class GameService {
    fun raceAll(round: Int, cars: Cars) {
        for (i in 1..round) cars.moveAll()
    }
}