package racingcar

class Car(val name: String){

}

class CarRacingGame {
    fun start() {   // 시작부
        val cars = inputCarNames()   // 이름들 입력부. 이름들 리스트 반환받음
//        val rounds = inputRounds()   //

    }

    private fun inputCarNames(): List<Car> {     // 차 이름 입력부
        print("Enter the names of the cars (comma-separated):\n")
        val input = readln()
        val names = input.split(',')
        println(names)

        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Car names must be up to 5 characters.")
        }

        return names.map { Car(it) }
    }



}


fun main() {
    // TODO: Implement the program



}
