package TwentyTwentyOne.Day1

import java.io.File
import java.io.InputStream

//Uppgiften var inte svår men koden kändes konstig när jag skrev den
class aocLogicOneA(){

    //Här hämtar jag bara en lista string från en fil och parsear dem till ints innan de retureras
    fun getListFromFile(filePath: String): MutableList<Int> {
        val inputStream: InputStream = File(filePath).inputStream()
        val listFromFile = mutableListOf<Int>()
        inputStream.bufferedReader()
            .useLines { lines -> lines
                .forEach {
                    listFromFile.add(it.toInt()) } }
        return listFromFile
    }

    //Väldigt enkel lösning till problemet, tror jag skrivit näst intill identisk kod i någon av våra  java böcker.
    fun calculateIncreaseInList(list: MutableList<Int>) : Int{
        var counter = 0
        var prevInt = 2000000
        for(i in list){
            if (i > prevInt){
                counter++
            }
            prevInt = i
        }
        return counter
    }
}

fun main(){
    val logic = aocLogicOneA()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day1/puzzleInput"
    println(logic.calculateIncreaseInList(
        logic.getListFromFile(
            filepath
        )))
}