import java.io.*;

val br = BufferedReader(InputStreamReader(System.`in`))
val N = br.readLine().toInt()
val map = HashMap<Int, Int>();

fun main() {

    for (i in 1..N) {
        val input = br.readLine().split(" ")
        if (input.size == 2)
            printResult(input[0], input[1].toInt())
        else
            printResult(input[0], input[1].toInt(), input[2].toInt())
    }
}

fun printResult(command: String, input1: Int, input2: Int = 0) {
    if (command == "add")
       map[input1] = input2
    else if (command == "find")
        if(map.containsKey(input1)) println(map[input1]) else println("None")
    else if (command == "remove")
        map.remove(input1)
}