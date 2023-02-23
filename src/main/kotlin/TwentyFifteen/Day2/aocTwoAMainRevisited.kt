package TwentyFifteen.Day2

import java.io.File
import kotlin.math.log

class aocTwoMainRevisited(){

    /*
        Lösningen jag hittar i kotlin ser ut såhär:
        override fun partOne() =
            inputList
                    .map { it.split("x").map { x -> x.toInt() } }
                    .fold(0) { total, (l, w, h) ->
                        total + (2 * l * w) + (2 * w * h) + (2 * h * l) + min(l * w, min(w * h, h * l))
                    }

     Jag tänkte bryta ut hans lambdas och sätta dem i mina metoder (om jag lyckas)
     */



fun getStringListFromFile(fileName: String): List<String> = File(fileName).readLines()


fun calculateWrappingPaperNeeded(list: List<List<Int>>) : Int{
    var wrappingPaperNeeded = 0
    for(miniList in list) wrappingPaperNeeded += calculation(miniList)
    return wrappingPaperNeeded
}

//Använder hans lambda för att ändra hela min lista till en listlist av ints
fun convertStringListToListListOfIntsThatContains3Values(list: List<String>) : List<List<Int>> {
    return list.map{it.split("x").map { i -> i.toInt() }}
}

//Behövde skriva om koden lite eftersom att jag inte kastar runt strings
fun calculation(inputList: List<Int>) : Int{
    val list = inputList
    val a = list.get(0) * list.get(1)
    val b = list.get(1) * list.get(2)
    val c = list.get(2) * list.get(0)
    val sortingList = listOf(a,b,c).sorted()
    return 2*a+2*b+2*c + sortingList[0]
}
}
fun main(){
    val logic = aocTwoMainRevisited()
    val filepath = "src/main/resources/TwentyFifteen.Inputs/Inputs/Day2/puzzleInput"

    println(logic.calculateWrappingPaperNeeded(logic.convertStringListToListListOfIntsThatContains3Values(logic.getStringListFromFile(filepath))))
}