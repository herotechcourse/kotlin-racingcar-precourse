package racingcar.model

/**
 * Manages a collection of [Car] objects.
 *
 * @property cars List of car instances.
 */
class Cars (private val cars:List<Car>){

    companion object{
        fun from(names:List<String>):Cars{
            return Cars(names.map { Car(it.trim()) })
        }
    }
    /**
     * Moves all cars by one step based on their move conditions.
     */
    fun moveAll(){
        cars.forEach{it.move()}
    }

    /**
     * Finds the winner(s) — cars that have reached the maximum position.
     *
     * @return List of winning [Car] objects.
     */
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

    /**
     * Returns the list of cars.
     *
     * @return List of [Car] objects.
     */
    fun getCars() :List<Car> = cars

}
