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
}