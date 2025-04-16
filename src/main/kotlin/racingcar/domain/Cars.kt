package racingcar.domain

class Cars(private val cars: List<Car>) {

    fun raceOnce() {

    }

    fun getWinners(): List<Car> {

        return emptyList()
    }

    companion object {
        fun from(names: List<String>): Cars {

            return Cars(emptyList())
        }

        private fun validateDuplicate(names: List<String>) {

        }
    }
}