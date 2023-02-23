package TwentyFifteen.Day1

import java.io.File
import kotlin.math.log

class aocOneAMain {

    //Hämtar en string
    fun getStringFromFile(fileName: String): String = File(fileName).readText()


    //Foreach char in string räknar ut om man går upp eller ner en våning
    fun calculateFloor(input: String): Int {
        var returnable = 0
        for (c in input){
            if(c.equals('(')) returnable = returnable+1 else returnable = returnable-1
        }
        return returnable
    }
}

fun main(){
    val logic = aocOneAMain()
    val filepath = "src/main/resources/TwentyFifteen.Inputs/Inputs/Day1/puzzleInput"
    println(logic.calculateFloor(logic.getStringFromFile(filepath)))
}