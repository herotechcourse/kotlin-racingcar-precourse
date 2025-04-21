package racingcar

import racingcar.service.RaceSetting

fun main() {
    try {
        RaceSetting.run()
    } catch (e: IllegalArgumentException) {
        throw e
    }
}