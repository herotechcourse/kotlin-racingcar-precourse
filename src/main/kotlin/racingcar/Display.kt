package racingcar

class Display {

    fun showQ1(){
        println("Enter the names of the cars (comma-separated):")
    }

    fun showQ2(){
        println("How many rounds will be played?")
    }

    fun showTitle(){
        print("Race Results")
    }

    fun printRound(rndRes:MutableMap<String,String>){

        rndRes.forEach{
            println(it.key +" : "+ it.value)

        }
    }

    fun printWinner(rndRes:MutableMap<String,String>){
        val checkOutput=CheckOutput()
        val winners=checkOutput.checkSingle(rndRes)

        println()
        print("Winners : $winners")
    }


}