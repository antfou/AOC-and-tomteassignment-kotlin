package TwentyTwentyOne.Day2

import java.io.File
import java.io.InputStream
import java.util.StringJoiner
import kotlin.math.log

//Den här uppgiften var skit enkel att lösa om jag skriver som att jag skrev i java
class aocTwoAMain{

    //Gör en string lista from file
    fun getListFromFile(filePath: String): MutableList<String> {
        val inputStream: InputStream = File(filePath).inputStream()
        val listFromFile = mutableListOf<String>()
        inputStream.bufferedReader()
            .useLines { lines -> lines
                .forEach {
                    listFromFile.add(it) } }
        return listFromFile
    }

    //Tar in en lista för att räkna hur mycket vi rör oss upp och frammåt
    fun calculateSubmarineMovement(list: List<String>): List<String>{
        var returnable = mutableListOf<String>()

        var distance = 0
        var depth = 0

        //För varje kommando i listan:
        for (i in list){
            //Hämtar en mindre lista via en annan funktion bara för att separera sträng och int
            val tinyList = getAsList(i)
            //Om vi ska upp, ner eller fram
            val direction = tinyList.get(0)
            //Hur långt vi ska åka
            val velocity = tinyList.get(1).toInt()

            //When istället för switch, olika uträkningar för de olika riktningarna
            when(direction){
                "forward" -> distance = distance + velocity
                "up" -> depth = depth - velocity
                "down" -> depth = depth + velocity
            }
        }
        //Addar bägge strängar till en lista innan jag returerar den
        returnable.add("distance $distance")
        returnable.add("depth $depth")
        return returnable
    }

    //Gör bara en riktningen gånger den andra riktningen
    fun calculateTotalTraveled(list: List<String>): Int{
        val x = getAsList(list.get(0)).get(1).toInt()
        val y = getAsList(list.get(1)).get(1).toInt()
        return x * y
    }

    //En funktion jag gjorde för det blev för stökigt att splitta strängar i andra funktioner
    fun getAsList(original: String) : List<String>{
        return listOf(
            original.split(" ").get(0),
            original.split(" ").get(1)
            )
    }
}

fun main(){
    val logic = aocTwoAMain()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day2/puzzleInput"
    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(0))
    println(logic.calculateSubmarineMovement(logic.getListFromFile(filepath)).get(1))
    println("total distance: " + logic.calculateTotalTraveled(logic.calculateSubmarineMovement(logic.getListFromFile(filepath))))
}