package TwentyFifteen.Day1

import java.io.File

class aocOneAMainRevisited {

    fun getStringFromFile(fileName: String): String = File(fileName).readText()

    //Fanns inte mycket man kan göra rent logiskt, men man kan skriva om funktionaliteten till en lambda
    fun calculateFloor(input: String): Int = input.count { it == '(' } - input.count { it == ')' }

}
fun main(){
    val logic = aocOneAMainRevisited()
    val filepath = "src/main/resources/TwentyFifteen.Inputs/Inputs/Day1/puzzleInput"

    println(logic.calculateFloor(logic.getStringFromFile(filepath)))
}
