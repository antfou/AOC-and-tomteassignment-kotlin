package TwentyTwentyOne.Day3

import java.io.File


/*
Todd har löst det såhär:
 fun solvePart1(): Int {
        val gamma = input.first().indices.map { column ->
            if (input.count { it[column] == '1' } > input.size / 2) '1' else '0'
        }.joinToString("")
        val epsilon = gamma.map { if (it == '1') '0' else '1' }.joinToString("")
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    Jag kollade lite på den redan när jag skrev koden till att böja med bara för att lista ut
    hur jag skulle konvertera till decimal, det visar sig att de var toInt(2).
    Min kod är väldigt lik den förrutom mycket fulare och inga lambdas, så jag ska skriva om med
    lambdas och följa hans exempel.


    Sen har jag också följt:
    https://blog.jetbrains.com/kotlin/2021/12/advent-of-code-2021-in-kotlin-day-3/

    och som jag nämnt i textfilen så har jag behövt härma på väldigt många delar av koden,
    det var en ganska jobbig uppgift och nästan alla resurser och kodexempel jag kunde
    hitta på reddit och stackoverflow var lite för avancerade för mig.

*/
class newAocThreeAMain {
    fun getListFromFile(fileName: String): List<String> = File(fileName).readLines()

    fun calculateEnergyConsumption(list: List<String>): Int {
        val gamma = StringBuilder()
        val epsilon = StringBuilder()

        //Gjorde om detta till lite mer funktionellt
        val columnsIndices = list[0].indices
        for (column in columnsIndices) {
            if (countZeroesAndOnes(list, column).first < countZeroesAndOnes(list, column).second) gamma.append("0") else gamma.append("1")
            if (countZeroesAndOnes(list, column).first > countZeroesAndOnes(list, column).second) epsilon.append("0") else epsilon.append("1")

        }
        //Tog bort några onödiga funktioner och bara slängde in dem här
        return gamma.toString().toInt(2) * epsilon.toString().toInt(2)
    }

    fun countZeroesAndOnes(list: List<String>, column: Int): Pair<Int, Int> {
        var zero = 0
        var one = 0
        for (line in list) if (line[column] == '0') zero++ else one++
        return zero to one
    }
}

fun main(){
    val logic = newAocThreeAMain()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day3/puzzleInput"
    println(logic.calculateEnergyConsumption(logic.getListFromFile(filepath)))
}