package Day1

import java.io.File

object Day1Main {

}
fun readTextFromFile(path: String) = File(path).readLines()

fun solution1(list: List<String>) :Int{
    var returnable = 0
    for(line in list){
        returnable += fuelCalculation(line.toInt())
    }
    println(returnable)
    return returnable
}

fun solution2(list: List<String>) :Int{
    var returnable = 0
    for(line in list){
        returnable += fuelLoop(line.toInt())
    }
    println(returnable)
    return returnable
}

fun fuelLoop(input: Int) : Int{
    var int = input
    var returnable = 0
    while(fuelCalculation(int) > 0){
        int = fuelCalculation(int)
        returnable += int
    }
    return returnable
}

fun fuelCalculation(input: Int) : Int{
    return input/3-2
}