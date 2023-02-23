package TwentyFifteen.Day2

import java.io.File
import kotlin.math.log

class aocTwoBMain(){
    fun getStringListFromFile(fileName: String): List<String> = File(fileName).readLines()

    fun convertStringListToListListOfIntsThatContains3Values(list: List<String>) : List<List<Int>> {
        return list.map{it.split("x").map { i -> i.toInt() }}
    }

    fun calculateRibbonNeeded(list: List<List<Int>>) : Int{
        var ribbonNeeded = 0
        for(miniList in list) ribbonNeeded += calculation(miniList)
        return ribbonNeeded
    }

    //Uppgiften var identisk till den förra, behövde bara slänga in en annan ekvasion
    fun calculation(inputList: List<Int>): Int{
        val sortedList = inputList.sorted()
        return (2*sortedList[0]) +
                (2*sortedList[1]) +
                (sortedList[0]*sortedList[1]*sortedList[2])
    }
}

fun main(){
    val logic = aocTwoBMain()
    val filepath = "src/main/resources/TwentyFifteen.Inputs/Inputs/Day2/puzzleInput"
    println(logic.calculateRibbonNeeded(
        logic.convertStringListToListListOfIntsThatContains3Values(
            logic.getStringListFromFile(
                filepath))))
}