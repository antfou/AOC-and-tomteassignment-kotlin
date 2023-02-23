package TwentyTwentyOne.Day2

import java.io.File

class newAocTwoBMain{
    //Snopade runt i github repos och hittade att man kunde skriva om hela min metod till en jävla line
    fun getListFromFile(fileName: String) : List<String> = File(fileName).readLines()


    /*
     Todd har löst det såhär:
     private data class Submarine(
     val depth: Int = 0,
     val position: Int = 0,
     val aim: Int = 0      // NEW!
) {

    // answer() and movePart1() are the same

    fun movePart2(command: Command) =
        when (command.name) {
            "forward" -> copy(
                position = position + command.amount,
                depth = depth + (aim * command.amount)
            )
            "down" -> copy(aim = aim + command.amount)
            "up" -> copy(aim = aim - command.amount)
            else -> error("Invalid command")
        }
}


       Det finns inte super mycket jag vill göra, förutom att lägga till lite
       felsöking jag jade missat samt fixa min filereader

    */

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

                //Lägger till en else i min (when) för lite felsökning
                else -> error("fel vid inläsning av data")
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
    val logic = newAocTwoBMain()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day2/puzzleInput"
    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(0))
    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(1))
    println("total distance: " + logic.calculateTotalTraveled(logic.calculateSubmarineMovement(logic.getListFromFile(filepath))))
}
