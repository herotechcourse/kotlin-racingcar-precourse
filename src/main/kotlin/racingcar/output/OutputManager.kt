package racingcar.output

private val sb = StringBuilder();

fun addLine(){
    sb.append('\n');
}
fun addLine(line: String){
    sb.append(line);
    addLine();
}

fun printFromOutputManager(){
    println(sb);
    sb.clear();
}
