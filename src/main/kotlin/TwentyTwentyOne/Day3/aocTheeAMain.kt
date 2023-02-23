package TwentyTwentyOne.Day3

import java.io.File
import kotlin.text.StringBuilder

class aocThreeAMain {
    //Jag har aldrig jobbat binärt och inte med indices tidigare så denna uppgift tog väldans mycket googlande
    fun getListFromFile(fileName: String): List<String> = File(fileName).readLines()

    //Returerar en Stringbuilder med mitt binära tal för gamma grejen
    fun calculateEnergyConsumption(list: List<String>) : Int{
        val stringBuilderGamma = StringBuilder()
        val stringBuilderEpsilon = StringBuilder()

        //Variabeln sparar bara alla våra giltiga index's, indices
        val columnsIndices = list[0].indices
        for(colum in columnsIndices){
            //Kallar på min andra metod för att få ett pair av ints, den första blir 0 andra blir 1
            val zero = countZeroesAndOnes(list,colum).first
            val one = countZeroesAndOnes(list,colum).second
            //Lägger till allt i stringbuilders för att få min rad binär
            val winner = if(zero > one) "0" else "1"
            val loser = if(zero < one) "0" else "1"
            stringBuilderGamma.append(winner)
            stringBuilderEpsilon.append(loser)

        }
        //Här räknar jag ut dem med hjälp av min metod som översätter binär till decimal
        return getBinaryValue(stringBuilderGamma) * getBinaryValue(stringBuilderEpsilon)
    }

    //Returerar ett pair av ints, första blir 0 andra blir 1
    fun countZeroesAndOnes(list: List<String>, column: Int) : Pair<Int, Int>{
        var zero = 0
        var one = 0
        for(line in list){
            if(line[column] == '0') zero++ else one++
        }
        return zero to one
    }

    //Hämta binära värdet av vår stringBuilder, dog för alltid att lista ut hur jag ändrade ett värde till decimal
    fun getBinaryValue(sb: StringBuilder) :Int{
        return sb.toString().toInt(2)
    }

}

fun main(){
    val logic = aocThreeAMain()
    val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day3/puzzleInput"
    println(logic.calculateEnergyConsumption(logic.getListFromFile(filepath)))
}