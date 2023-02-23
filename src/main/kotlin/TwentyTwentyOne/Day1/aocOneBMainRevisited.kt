package TwentyTwentyOne.Day1

import java.io.File
import java.io.InputStream

class newAocLogicOneB() {

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

    /*Den här gången tänkte jag kolla runt om det går att skriva denna lambda lite enklare och på ett
    sätt som inte tar mig mer än 90min

    på  https://todd.ginsberg.com/post/advent-of-code/2021/day1/
    har det lösts såhär:
        fun solvePart2(): Int =
        input
            .windowed(3, 1) { it.sum() }
            .zipWithNext()
            .count { it.first < it.second }

    zip with next hade löst alla mina problem utan att behöva göra en till windowed.

    på https://github.com/antonarhipov/advent-of-code-2021/blob/main/src/Day01.kt
    har det lösts såhär:

        fun part2(input: List<Int>): Int {
            return input
                .windowed(4)
                .count {
                    it[0] < it[3]
                }
        }

        jag har inte 100% koll på den koden så hade jag skrivit om allt igen hade jag gått med zipWithNext()



        Ett enkelt exempel stulen från den världskända utvecklaren Jani Hakala:

        val newlist = intList.windowed(3, 1) { it.sum() }
        repeat(newlist.size - 1) {
            if (newlist.get(it) < newlist.get(it + 1)) {
                counter++
            }
        }

        Läsbar kod som jag faktiskt förstår, lite sur att jag inte listade ut det innan jag behövde
        gräva mig ner i kotlins dokumentation om list funktioner
    */

    fun calculateIncreaseInList(input: List<Int>): Int {
        return input
            .windowed(size = 3,step = 1)
            .zipWithNext()
            .count{
                    (a,b) -> a.sum() < b.sum() }
        //här går et att byta ut a och b mot "it" men jag föredrar bara a,b
    }
}


fun main() {
    val logic = newAocLogicOneB()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day1/puzzleInput"

    println(logic.calculateIncreaseInList(logic.getListFromFile(filepath)))
}
