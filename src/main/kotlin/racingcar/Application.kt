package racingcar

import camp.nextstep.edu.missionutils.Randoms

val maxRounds: Int = Int.MAX_VALUE

fun main() {
    val names: List<String> = getUserInputNames()
    val cars: List<Car> = makeCars(names)

    val game = Game(cars)

    val numRounds: Int = getUserInputRounds()
    game.play(numRounds)
    
    // raceThem(cars, numRounds)
    // printWinners(cars, numRounds)
}

fun makeCars(names: List<String>): List<Car> {
    return names.map { name -> Car(name) }
}

// fun raceThem(cars: List<Car>, nRounds: Int) {
//     for (i in 0 until nRounds) {
//         cars.forEach { car ->
//             if (Randoms.pickNumberInRange(0, 9) >= moveIndicator) car.move()
//             car.printRoundStatus()
//         }
//         println("")
//     }
// }

// fun printWinners(cars: List<Car>, nRounds: Int) {
//     var roundsWon = nRounds
//     var foundFirstWin = false
//     print("Winners : ")
//     do {
//         cars.forEach { car ->
//             foundFirstWin = checkWinner(car, roundsWon, foundFirstWin) || foundFirstWin
//         }
//     } while (!foundFirstWin && roundsWon-- > 0)
// }

// fun checkWinner(car: Car, roundsWon: Int, foundFirstWin: Boolean): Boolean {
//     if (car.getMovesMade() == roundsWon) {
//         printWinnerName(car, foundFirstWin)
//         return true
//     }
//     return false
// }

// fun printWinnerName(car: Car, foundFirstWin: Boolean) {
//     if (foundFirstWin) print(", ")
//     print("${car.getName()}")
// }
