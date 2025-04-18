package racingcar.domain

class Cars (private val cars:List<Car>){

    companion object{
        fun generate(names:List<String>):Cars{
            return Cars(names.map { Car(it.trim()) })
        }
    }
}