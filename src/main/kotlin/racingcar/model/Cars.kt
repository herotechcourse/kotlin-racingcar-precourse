package racingcar.model

class Cars (private val cars:List<Car>){

    companion object{
        fun from(names:List<String>):Cars{
            return Cars(names.map { Car(it.trim()) })
        }
    }

    fun moveAll(){
        cars.forEach{it.move()}
    }

    fun findWinners(): List<Car>{
        val winners = mutableListOf<Car>()
        val maxPosition = cars.maxOf { it.getPosition() }
        for(car in cars){
            if(car.getPosition()==maxPosition){
                winners.add(car)
            }
        }
        return winners
    }
    fun getCars() :List<Car> = cars


}