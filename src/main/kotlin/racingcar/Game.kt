package racingcar

class Game{
    private val cars: MutableList<Car> = mutableListOf()
    private val numberOfRounds:Int
    init {
        //read input here
        cars.add(Car("Dum1"))
        cars.add(Car("Dum2"))
        cars.add(Car("Dum3"))
        cars.add(Car("Dum4"))
        numberOfRounds = 0
    }
//    fun printCars(){
//        for (car in cars)
//            car.printCar()
//    }
}