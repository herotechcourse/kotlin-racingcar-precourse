package racingcar


fun isMove(number : Int) : Boolean {
    return number >= 4
}


fun validString(string : String) : Boolean {
    if(string.length>5)
        return false
    if(string == "")
        return false
    return true
}

fun <T : Vehicle>makeVehicle(constructor: (String) -> T, string: String) : T{
    return constructor(string)
}
