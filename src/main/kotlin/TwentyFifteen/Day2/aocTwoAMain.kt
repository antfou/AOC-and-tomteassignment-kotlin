package TwentyFifteen.Day2

import java.io.File
import kotlin.math.log


//math = 2*l*w + 2*w*h + 2*h*l.
class aocTwoAMain {

    fun getStringListFromFile(fileName: String): List<String> = File(fileName).readLines()

    fun calculateWrappingPaperNeeded(list: List<String>) : Int{
    var wrappingPaperNeeded = 0
    for(string in list){
        val listOfMeasurements = convertStringToListOfIntsThatContains3Values(string).sorted()
        val a = listOfMeasurements.get(0)
        val b = listOfMeasurements.get(1)
        val c = listOfMeasurements.get(2)
        val total = calculation(a,b,c)
        wrappingPaperNeeded += total
    }
    return wrappingPaperNeeded
    }

    fun convertStringToListOfIntsThatContains3Values(inputString: String) : List<Int> {
        val splitStrings = inputString.split("x")
        return splitStrings.map(String::toInt)
    }

    fun calculation(a: Int, b: Int, c: Int) : Int{
        val A = a*b
        val B = b*c
        val C = a*c
        val list = listOf(A,B,C).sorted()
        return 2*A+2*B+2*C + list[0]
    }
}
fun main(){
    val logic = aocTwoAMain()
    val filepath = "src/main/resources/TwentyFifteen.Inputs/Inputs/Day2/puzzleInput"
    println(logic.calculateWrappingPaperNeeded(logic.getStringListFromFile(filepath)))
}