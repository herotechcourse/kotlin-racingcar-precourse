package racingcar

import camp.nextstep.edu.missionutils.Console

class StringUtils {
    companion object{
        fun checkName(name:String){
            if (name.length>5)
                throw IllegalArgumentException("names cannot exceed 5 characters!")
            if (name.isBlank())
                throw IllegalArgumentException("each car needs a name!")
        }
        fun hasDuplicateNames(names: List<String>){
            val seenNames = HashSet<String>()
            for (name in names) {
                if (!seenNames.add(name)) {
                    throw IllegalArgumentException("More than one car have the same name!")
                }
            }

        }
        fun getUserName():List<String>{
            println("Enter the names of the cars (comma-separated):")
            val userInput = Console.readLine()
            var carsName = userInput.split(",")
            carsName.forEach{
                checkName(it)
            }
                hasDuplicateNames(carsName)
            return carsName
        }
        fun getRoundNumber():Int{
            println("How many rounds will be played?")
            try {
                val userInput = Console.readLine()
                val numberOfRounds = Integer.parseInt(userInput)
                return numberOfRounds
            }catch (e:Exception){
                throw IllegalArgumentException("You entered invalid number!")
            }
        }
        fun generateCars(names:List<String>):List<Car>{
            var cars = ArrayList<Car>()
            names.forEach{
                cars.add(Car(it))
            }
            return cars
        }
    }
}