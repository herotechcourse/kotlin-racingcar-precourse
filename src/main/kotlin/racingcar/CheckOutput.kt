package racingcar

class CheckOutput {

    fun checkSingle(rndRes:MutableMap<String,String>): String {
        var name=""
        var singleWin=true
        var maxLen=rndRes.maxByOrNull{it.value.length}?.value?.length
        rndRes.forEach{

            val singleCheck= maxLen?.let { it1 -> checkSingleWin(singleWin,it.value.length, it1) }
            if (singleCheck=="first"){
                maxLen=it.value.length
                name+=it.key
                singleWin=false
            }

            if(singleCheck=="multi"){
                maxLen=it.value.length
                name+=", "+it.key
            }

        }

        return name
    }

    fun checkSingleWin(single: Boolean,distance: Int, maxLen:Int): String{
        val chdtance= checkDistance(distance,maxLen)
        if(single && chdtance){
            return "first"
        }


        if(!single&& chdtance){
            return "multi"
        }

        return "noWin"
    }

    fun checkDistance(distance:Int,maxLen:Int):Boolean{
        return distance==maxLen
    }
}