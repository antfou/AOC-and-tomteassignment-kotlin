package Tomtar




class Logic() {


    //For each tomte som jobbar under nyckeln så kallas på metoden igen för att lägga in alla i en list
    fun hämtaTomte(str: String,
                   map: Map<String,List<Tomte>>,
                   returnable: MutableList<String>) : List<String>{
        val string = str
        val list = map.getOrDefault(string, listOf())
        if(list.isNotEmpty()){
            for(tomte in list) {
                returnable.add(tomte.getNamn())
                hämtaTomte(tomte.getNamn(),skapaChefMap(),returnable)
            }
        }
        return returnable
    }

    //Skriver ut allt ur en lista för att jag är lat
    fun skrivUtStringList(list: List<String>){
        if(list.isNotEmpty()){
            for (str in list){
                println(str)
            }
        }
    }


    //Map av alla tomtar
    fun skapaChefMap() = mapOf(
        "Tomten" to listOf(
            Tomte(namn = "Glader"),
            Tomte(namn = "Butter")
        ),
        "Glader" to listOf(
            Tomte(namn = "Tröger"),
            Tomte(namn = "Trötter"),
            Tomte(namn = "Blyger")
        ),
        "Trötter" to listOf(
            Tomte(namn = "Skumtomten")
        ),
        "Skumtomten" to listOf(
            Tomte(namn = "Dammråttan")
        ),
        "Butter" to listOf(
            Tomte(namn = "Rådjuret"),
            Tomte(namn = "Nyckelpigan"),
            Tomte(namn = "Haren"),
            Tomte(namn = "Räven")
        ),
        "Räven" to listOf(
            Tomte(namn = "Gråsuggan"),  
            Tomte(namn = "Myran")
        ),
        "Myran" to listOf(
            Tomte(namn = "Bladlusen")
        )
    )
}

class Tomte (private val namn: String = "Buser"){
    fun getNamn() = namn
}



fun main(){
    val logic = Logic()
    logic.skrivUtStringList(logic.hämtaTomte("Tomten",logic.skapaChefMap(), mutableListOf()))


}




//Inte korrekt men jag jobbade länge med skiten så jag sparar den
//Och då såg tomte classen annorlunda ut
//"data class Tomte (val namn: String, val direktChefÖver: List<Tomte>)
/*fun skapaTomtarna() = Tomte(
    namn = "Tomten", direktChefÖver = listOf(
        Tomte(namn = "Glader", direktChefÖver = listOf(
            Tomte(namn = "Tröger", direktChefÖver = listOf()),
            Tomte(namn = "Blyger", direktChefÖver = listOf()),
            Tomte(namn = "Trötter", direktChefÖver = listOf(
                Tomte(namn = "Skumtomten", direktChefÖver = listOf(
                    Tomte(namn = "Damråttan",direktChefÖver =  listOf())
                ))
            ))
        )),
        Tomte(namn = "Butter", direktChefÖver = listOf(
            Tomte(namn = "Rådjuret", direktChefÖver = listOf()),
            Tomte(namn = "Nyckelpigan", direktChefÖver = listOf()),
            Tomte(namn = "Haren", direktChefÖver = listOf()),
            Tomte(namn = "Räven", direktChefÖver = listOf(
                Tomte(namn = "Gråsuggan", direktChefÖver = listOf()),
                Tomte(namn = "Myran", direktChefÖver = listOf(
                    Tomte(namn = "Badlusen", direktChefÖver = listOf())
                ))
            ))
        ))
    )
)
*/