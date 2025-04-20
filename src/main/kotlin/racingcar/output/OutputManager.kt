package racingcar.output

private val sb = StringBuilder();

fun addLine(line: String){
    sb.append(line).append('\n');
}

fun print(){
    print(sb);
    sb.clear();
}
