package TwentyTwentyOne.Day1

import java.io.File
import java.io.InputStream
import kotlin.math.log


//Jag löser del2 efter att jag kollat på en del facit från del 1, jag har bättre koll på hur-
//kotlin vill att jag leker runt med ints i listor nu
class aocLogicOneB() {

    //Samma gamla file reader, gör filerna till en IntList
    fun getListFromFile(filePath: String): MutableList<Int> {
        val inputStream: InputStream = File(filePath).inputStream()
        val listFromFile = mutableListOf<Int>()
        inputStream.bufferedReader()
            .useLines { lines ->
                lines
                    .forEach {
                        listFromFile.add(it.toInt())
                    }
            }
        return listFromFile
    }

    //Tog för alltid att lista ut hur jag skulle kombinera .windowed korrekt för att hatera mina
    //list<list<list<list>>>>lists

    //Nu i efterhand när jag kollat på flera lösningar hade jag ablsolut inte löst det såhär :D
    fun calculateIncreaseInList(input: List<Int>): Int {
        //Returnerar i början för att jag lyckades smälla ihop allt till bara en lambda
        return input
                //Här använder jag windowed för att para ihop alla ints i sets av 3 i min lista -
                //försökte en stund leka med forEach men windowed fixar allt själv
            .windowed(size = 3,step = 1)
                //Här kör vi windowed igen för att göra par av 2 av paren av 3...
            .windowed(size = 2,step = 1)
                //Sen en snabb count på par a och par 2 för att får siffran jag vill returera (antalet gånger -
            //par b är större än par a, och de listar jag ut med att köra .sum på bägge delarna bara
            .count{
                (a,b) -> a.sum() < b.sum() }
    }
}


fun main() {
    val logic = aocLogicOneB()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day1/puzzleInput"
    println(logic.calculateIncreaseInList(logic.getListFromFile(filepath)))
}
