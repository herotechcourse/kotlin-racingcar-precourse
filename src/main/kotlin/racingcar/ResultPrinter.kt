package racingcar

class ResultPrinter : Printer{
    override fun printCurrentCarPosition(cars: List<Car>) {
        for (car in cars) {
            println(car.getName() + " : " + "-".repeat(car.getPosition()))
        }
        println()
    }
}