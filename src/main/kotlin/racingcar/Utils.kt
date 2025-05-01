package racingcar

fun validString(string : String) : Boolean {
    if(string.length>5)
        return false
    if(string == "")
        return false
    return true
}

fun <T : Vehicle>makeVehicle(constructor: (String) -> T, args: String) : T = constructor(args)

