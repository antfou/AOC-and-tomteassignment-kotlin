package TwentyTwentyOne.Day5
import TwentyTwentyOne.Day5.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


class Day5MainTest{
    //TIP OF THE DAYS MED JOBBIGA LAMBDAS
        //skriv
            //.aslo{println("bla bla bla $it)} närsom i en lambda ifall du vill kika under huven

    //TIP OF THE DAY: Extract
        //använde i en if sats när jag ville upprepa samma conditions i en annan if-sats
            //Ctrl+ALt+M extraherade mina conditions till en egent funktion


    //Skrev all kod i testerna medans jag höll Day5Main.solution empty, sedan när alla andra tester var gröna
    //och `test inputs with 5 as expected` fortfarande var röd så flyttade jag över min kod till min main och
    //jobbade tills `test inputs with 5 as expected` var grönt och då hade jag lösningen

    //sen hoppade jag tillbaka in för att göra part2, ändrade flera tester

    @Test
    //Standard test för att kolla slutresultatet med det jag vet är korrekt
     fun `test inputs with 5 as expected`() {
        val filepath = "src/test/resources/TwentyTwentyOne/Inputs/Day5/TestInput.txt"
        val input = Day5Main.readFromTextFileToStringList(filepath)
        val actual = Day5Main.solutionForPart1(input)
        val expected = 5

        assert(actual.equals(expected))
    }

    @Test
    //Standard test för att kolla slutresultatet med det jag vet är korrekt, via detta och .also så fick jag fram svaret
    fun `actual solution test with 6225 as expected`() {
        val filepath = "src/main/resources/TwentyTwentyOne/Inputs/Day5/Input"
        val input = Day5Main.readFromTextFileToStringList(filepath)
        val actual = Day5Main.solutionForPart1(input)
        val expected = 6225

        assert(actual.equals(expected))
    }


    //nested inner testclass förjag ville se om det går att göra så
    @Nested
    inner class DrawLineTest{
        @Test
        //testar om vi kan dra sträck i ena riktiningen med coordinaterna vi fick
        internal fun `check if horizontal lines can be drawn`() {
            val actual: List<Point> = "0,9 -> 5,9".drawLine(::noDiagonals)

            assert(actual.contains(at(0,9)))
            assert(actual.contains(at(1,9)))
            assert(actual.contains(at(2,9)))
            assert(actual.contains(at(3,9)))
            assert(actual.contains(at(4,9)))
            assert(actual.contains(at(5,9)))
        }

        @Test
        //testar om vi kan dra sträck i den andra riktiningen med coordinaterna vi fick
        internal fun `check if vertical lines can be drawn`() {
            val actual: List<Point> = "9,0 -> 9,5".drawLine(::noDiagonals)

            assert(actual.contains(at(9,0)))
            assert(actual.contains(at(9,1)))
            assert(actual.contains(at(9,2)))
            assert(actual.contains(at(9,3)))
            assert(actual.contains(at(9,4)))
            assert(actual.contains(at(9,5)))
        }

        @Test
        //testar om vi kan ha koll på vart våra linjer korsas
        internal fun `check for overlapping points`() {
            val firstTempLine = "0,9 -> 5,9".drawLine(::noDiagonals)
            val secopndTempLine = "0,9 -> 2,9".drawLine(::noDiagonals)

            val points =  buildList {
                addAll(firstTempLine)
                addAll(secopndTempLine)
            }

            val actual: Map<Point,Int> = points.getOverlappingCoordinates()
            assert(actual.contains(at(0,9))&&actual.containsValue(1))
            assert(actual.contains(at(1,9))&&actual.containsValue(1))
            assert(actual.contains(at(2,9))&&actual.containsValue(1))

        }
    }
}

//Här liger koden som den var innan jag flyttade ut den

/*
private fun List<Point>.getOverlappingCoordinates(): Map<Point, Int> {
    return this.groupBy{it}.mapValues { it.value.size - 1}.filterValues { it > 0 }
}

private fun String.drawLine():List<Point>{
    val (pointA, pointB) = replace(" ","").split("->").take(2).map { it -> getPointsUsingString(it) }
    //If satsen dubbelkollar att alla linjär är vertikala eller horizontella
    if(pointA.x == pointB.x || pointA.y == pointB.y) {
        return pointA..pointB
    }else{
        return emptyList()
    }
}

private data class Point(val x: Int, val y: Int) {
    operator fun rangeTo(secondPoint: Point): List<Point> {
        val xRange = this.x..secondPoint.x
        val yRange = this.y..secondPoint.y

        //Ger mig en lista av points, ex:
                "0,3" +
                "1,3" +
                "2,3" +
                "3,3"


        return xRange.flatMap{ x->
            yRange.map{ y->
                Point(x,y)
            }
        }

        //Kod som inte funkade för att 0 inte var med
        //return xRange.zip(yRange).map { (x, y) -> Point(x, y) }
        //return xRange.also{ println("xRange: $it")}.zip(yRange.also{ println("yRange: $it")}).map { (x, y) -> Point(x, y) }
    }
}

private fun getPointsUsingString(str: String) : Point{
    //Tar in str, splittar, mappar to int och returerar ett point objekt
    val(x,y) = str.split(",").map{it.toInt()}
    return Point(x,y)
}

private fun at(x: Int,y: Int): Point = Point(x,y)
*/