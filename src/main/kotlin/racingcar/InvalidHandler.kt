package racingcar

class InvalidHandler {
    fun handleCommas(input: String){
        if(!input.contains(",")){
            throw IllegalArgumentException("Cars name should be separated by commas")
        }
    }
    fun handleNameLength(data: List<String>){
        data.forEach{
            if (it.length>5)
                throw IllegalArgumentException("Car names should not exceed 5 Characters")
        }
    }

    fun handleNameEmpty(data: List<String>){
        data.forEach{
            if(it.isEmpty())
                throw IllegalArgumentException("Car name should exceed 1 Character")
        }
    }

    fun duplicatedName(data:List<String>){
        if(data.size!=data.distinct().count())
            throw IllegalArgumentException("Duplicated Name exist!")
    }

    private fun isNumeric(data:String): Boolean{
        return try{
            data.toInt()
            true
        }
        catch (e: NumberFormatException){
            false
        }
    }
    fun convertInt(data:String){
        val converted=isNumeric(data)
        if(!converted){
            throw IllegalArgumentException("Invalid input : numbers only ")
        }

    }

}