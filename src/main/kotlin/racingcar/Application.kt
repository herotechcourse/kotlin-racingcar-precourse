package racingcar

fun main() {
    // TODO: Implement the program
}

fun getNames() { 
    println("Names of the cars (comma-separated):\n"); 
    val input = readln(); 
    val carNames: List<String> = input.split(",").map{name -> name.trim()}; 
} 
