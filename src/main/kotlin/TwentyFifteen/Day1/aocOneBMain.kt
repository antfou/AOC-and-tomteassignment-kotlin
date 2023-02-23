package TwentyFifteen.Day1

import java.io.File

class aocOneBMain {


    fun getStringFromFile(fileName: String): String = File(fileName).readText()


    //Håller en counter för att ha koll på hur många gånger man loopar och returerar countern
    fun calculateFloor(input: String): Int {
        var floor = 0
        var returnable = 0
        val basement = -1
        for (c in input){
            if(c.equals('(')) floor = floor+1 else floor = floor-1
            returnable ++
            if(floor.equals(basement)) break
        }
        return returnable
    }
}

fun main(){
    val logic = aocOneBMain()
    val filepath = "src/main/resources/TwentyFifteen.Inputs/Inputs/Day1/puzzleInput"

    println(logic.calculateFloor(logic.getStringFromFile(filepath)))
}