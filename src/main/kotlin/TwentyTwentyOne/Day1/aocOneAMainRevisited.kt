package TwentyTwentyOne.Day1

import java.io.File
import java.io.InputStream

//Dag 1 var inte en svår uppgift alls, men jag löste den som jag gjort i java
//I alla andra finare lösningar jag hittat online har de använt windowed och andra funktioner jag inte visste om
//Jag använder det i nya koden här
class newAocOneAMain {
    fun getListFromFile(filePath: String): MutableList<Int> {
        val inputStream: InputStream = File(filePath).inputStream()
        val listFromFile = mutableListOf<Int>()
        inputStream.bufferedReader()
            .useLines { lines -> lines
                .forEach {
                    listFromFile.add(it.toInt()) } }
        return listFromFile
    }

    //Fanns inte så mycket kod att sno / översätta till min eftersom att alla lösningar ble bara en lambda
    //Men jag hade ingen aning om att windowed var en grej och de verkar extremt användbart för int listor
    fun calculateIncreaseInList(list: MutableList<Int>): Int{
        return list.windowed(2).count{(a,b) -> a < b}
    }

    //ZipWithNext kan jag också ha använt, har läst på mer om funktioner som zip och windowed nu efter jag kollat
    //på andra lösningar, de är väldigt användbara
}

fun main(){
    val logic = newAocOneAMain()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day1/puzzleInput"
    println(logic.calculateIncreaseInList(logic.getListFromFile(filepath)))
}