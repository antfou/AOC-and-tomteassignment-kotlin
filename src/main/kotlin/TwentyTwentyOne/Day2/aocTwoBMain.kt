package TwentyTwentyOne.Day2

import java.io.File
import java.io.InputStream

class aocTwoBMain{

fun getListFromFile(filePath: String): MutableList<String> {
    val inputStream: InputStream = File(filePath).inputStream()
    val listFromFile = mutableListOf<String>()
    inputStream.bufferedReader()
        .useLines { lines -> lines
            .forEach {
                listFromFile.add(it) } }
    return listFromFile
}

fun calculateSubmarineMovement(list: List<String>): List<String>{
    var returnable = mutableListOf<String>()

    var distance = 0
    var depth = 0
    var aim = 0

    for (i in list){
        val command = Command(i)
        val direction = command.direction
        val velocity = command.distance

        when(direction){
            "forward" -> {
                distance = distance + velocity
                depth = depth + (aim * velocity)
            }
            "up" -> aim = aim - velocity
            "down" -> aim = aim + velocity
        }
    }
    returnable.add("distance $distance")
    returnable.add("depth $depth")
    return returnable
}

fun calculateTotalTraveled(list: List<String>): Int{
    val x = Command(list.get(0)).distance
    val y = Command(list.get(1)).distance
    return x * y
}

class Command(str: String){
    val direction = str.split(" ").get(0)
    val distance = str.split(" ").get(1).toInt()
}
}

fun main(){
    val logic = aocTwoBMain()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day2/puzzleInput"

    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(0))
    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(1))
    println("total distance: " + logic.calculateTotalTraveled(logic.calculateSubmarineMovement(logic.getListFromFile(filepath))))
}