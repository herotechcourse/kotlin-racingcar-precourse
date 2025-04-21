package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `should start the race and move cars`() {
        // 자동차 이름과 라운드를 설정
        val cars = listOf(Car("pobi"), Car("woni"))
        val race = Race(cars, 1)

        // 경주를 시작하고
        race.start()

        // 경주 후 각 자동차의 위치가 1 이상인지 확인
        assertThat(cars[0].position).isGreaterThan(0)
        assertThat(cars[1].position).isGreaterThan(0)
    }

    @Test
    fun `should return winners correctly`() {
        val car1 = Car("pobi").apply { position = 3 }
        val car2 = Car("woni").apply { position = 3 }
        val car3 = Car("javaji").apply { position = 2 }

        val race = Race(listOf(car1, car2, car3), 1)

        // 경주가 끝난 후 우승자들을 확인
        val winners = race.getWinners()

        assertThat(winners).containsExactlyInAnyOrder(car1, car2) // 위치가 동일한 두 차량이 우승
    }
}
