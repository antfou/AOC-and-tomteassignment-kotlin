package TwentyTwentyOne.Day5

import java.io.File

//2021 dag 5, part 1

//enda anledningen jag körde object över klass var för att det är enklare att skriva testerna då
object Day5Main {

    fun readFromTextFileToStringList(input: String) = File(input).readLines()

    //refererar till min constraint, låser mig till part1
    //jag skrev aldrig en part 2 så onöding men men
    fun solutionForPart1(list: List<String>) :Int {
        return list
            .map { it.drawLine(::noDiagonals) }
            .flatten()
            .getOverlappingCoordinates()
            .size
            //.also { println("Answer: $it") }
    }
}

//tar in en lista av linjer, mappar alla points till ett värde som är antalet gånger de
//korsar med en annan en annan linje och filtrerar bort alla som är >1 innan jag returerear en int
fun List<Point>.getOverlappingCoordinates(): Map<Point, Int> {
    return this
        .groupBy{it}
        .mapValues { it.value.size - 1}
        .filterValues { it > 0 }
}

//draw line tar in mina start och slut punkter sen "ritar" den upp en linje mellan punktA och punktB
//                                      '?' = optional, '=null' = default value
fun String.drawLine(constraint: ((Point, Point)-> Boolean)? = null) :List<Point>{
    val (pointA, pointB) = replace(" ","")
        .split("->")
        .take(2)
        .map { it -> getPointsUsingString(it) }

    //'..' används när man ska få fram rangen mellan 2 saker, extremt användbart under hela projektet
    return if(constraint != null){
        if(constraint(pointA,pointB)) {
            pointA..pointB
        }else{
            emptyList()
        }
    }else{
        //Här hade part 2 hamnat
        //TODO: part2
        pointA..pointB
    }
}

//används för att filtrerar bort diagonala linjer, kollar bara om x eller y har start och slut på samma linje
//ifall de returerar true betyder det att man kan dra en horizontell eller vertikal linje mellan punkterna
fun noDiagonals(pointA: Point, pointB: Point) = pointA.x == pointB.x || pointA.y == pointB.y

//Instansierar bara en point
fun at(x: Int,y: Int): Point = Point(x,y)


//här skickar jag in stängarna från puzzleinputten och gör points
fun getPointsUsingString(str: String) : Point {
    val(x,y) = str.split(",").map{it.toInt()}
    return Point(x,y)
}

//min dataklass point, bara ett sätt att hantera mina koordinater från min 'puzzleInput'
data class Point(val x: Int, val y: Int) {

    /*range to, den tar in 2 punkter och returerar alla punkter där imellan
    ex: rangeTo((0,9),(4,9)) ger dig
        0,9
        1,9
        2,9
        3,9
        4,9

     */
    operator fun rangeTo(secondPoint: Point): List<Point> {
        val xMinimum = Math.min(x,secondPoint.x)
        val yMinimum = Math.min(y,secondPoint.y)
        val xMaximum = Math.max(x,secondPoint.x)
        val yMaximum = Math.max(y,secondPoint.y)

        val xRange = xMinimum..xMaximum
        val yRange = yMinimum..yMaximum

        //flatmap + map för att få ut alla värden ur sina listor och få en "platt" lista
        return xRange
            .flatMap { x -> yRange
                .map { y -> Point(x, y)
                }
            }
    }
}
