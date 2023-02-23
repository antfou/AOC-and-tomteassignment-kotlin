package TwentyTwentyOne.Day2


import java.io.File
import java.io.InputStream
import java.util.StringJoiner
import kotlin.math.log

class newAocTwoAMain{

    fun getListFromFile(filePath: String): MutableList<String> {
        val inputStream: InputStream = File(filePath).inputStream()
        val listFromFile = mutableListOf<String>()
        inputStream.bufferedReader()
            .useLines { lines -> lines
                .forEach {
                    listFromFile.add(it) } }
        return listFromFile
    }

    /*
    Todd löser problemet såhär:
    class Day02(input: List<String>) {

    private val commands = input.map { Command.of(it) }

    private class Command(val name: String, val amount: Int) {
        companion object {
            fun of(input: String) = input.split(" ").let { Command(it.first(), it.last().toInt()) }
        }
    }
}
    private data class Submarine(
  val depth: Int = 0,
  val position: Int = 0
) {
    fun answer() = depth * position

    fun movePart1(command: Command): Submarine =
        when(command.name) {
            "forward" -> copy(position = position + command.amount)
            "down" -> copy(depth = depth + command.amount)
            "up" -> copy(depth = depth - command.amount)
            else -> error("Invalid command")
        }
}

    Det är samma struktur som min lösning fast lite finare med en nya klasser, han har en ny klass för
    submarine där han har distance traveled som värden han kan hämta vid behov och sen en klass för
    command för att dela upp inputs (jag gjorde bara en stringlist, men en klass verkar enklare)


    Den andra lösningen jag hittade gjorde såhär:
    fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        val instructions = input.map { it.split(' ') }
        for ((direction, amountString) in instructions) {
            val amount = amountString.toInt()
            when (direction) {
                "forward" -> horizontalPosition += amount
                "up" -> depth -= amount
                "down" -> depth += amount
            }
        }
        return horizontalPosition * depth
    }

    allt skrevs i main, och i en funktion, finns inte så mycket snygg kod att sno här men det visar att
    det går att kombinera funktionerna


    Den 3e lösningen jag kollade på hade inget super fancy, såg ungefär ut som toms lösning, men det
    verkar ballt att prova en "Command" klass istället för en List<String> så det ska jag implementera
    i min kod
    */

    fun calculateSubmarineMovement(list: List<String>): List<String>{
        var returnable = mutableListOf<String>()

        var distance = 0
        var depth = 0

        for (i in list){
            val command = Command(i)
            val direction = command.direction
            val velocity = command.distance

            when(direction){
                "forward" -> distance = distance + velocity
                "up" -> depth = depth - velocity
                "down" -> depth = depth + velocity
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
    val logic = newAocTwoAMain()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day2/puzzleInput"
    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(0))
    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(1))
    println("total distance: " + logic.calculateTotalTraveled(logic.calculateSubmarineMovement(logic.getListFromFile(filepath))))
}