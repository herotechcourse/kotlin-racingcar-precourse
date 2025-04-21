package racingcar

class Car(val name: String){

}

class CarRacingGame {
    fun start() {   // 시작부
        val cars = inputCarNames()   // 이름들 입력부. 이름들 리스트 반환받음
        val rounds = inputRounds()   //

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

    private fun inputRounds(): Int {     // 라운드 수 입력부
        print("How many rounds will be played?\n")
        val input = readln()

        val numInput: Int = input.toIntOrNull() ?: -1   //
        if(numInput < 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer.")
        }
        else{
            return numInput
        }
    }

}


fun main() {
    // TODO: Implement the program



}
