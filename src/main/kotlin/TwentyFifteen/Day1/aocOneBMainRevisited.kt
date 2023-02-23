package TwentyFifteen.Day1

import java.io.File

class aocOneBMainRevisited {

    fun getStringFromFile(fileName: String): String = File(fileName).readText()


    //En lösning jag hittade online var:
    /*override fun partTwo(): Int {
        var floor = 0
        return inputString.split().map {
            if (it == '(') ++floor else --floor
        }.indexOf(-1) + 1
    }*/

    //Där gör han allt i en lambda, och returnerar indexet av (-1)+1 vilket är svaret på frågan
    fun calculateFloor(input: String): Int {
        var floor = 0
        val basement = -1

        return input.map{ if(it=='(') ++floor else --floor }.indexOf(basement)+1
    }
    //När jag implementerar den kodsnutten i min lösning försvinner flera rader kod och det blir
    //mer läsbart
}

fun main(){
    val logic = aocOneBMainRevisited()
    val filepath = "src/main/resources/TwentyFifteen.Inputs/Inputs/Day1/puzzleInput"
    println(logic.calculateFloor(logic.getStringFromFile(filepath)))
}