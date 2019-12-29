import model.Ingredient
import model.InexactIngredient
import model.Recipe

fun main() {

//      DECLARACIONES

//Situaciones:
    val menu = 0
    val hacer = 1
    val ver = 2
    val salir = 3

//Mensajes:
    val inicio = "\n:: Bienvenido a Recipes Maker ::\n"

    val opciones: String = """
    Escribe el número correspondiente a la opción deseada:
    1. Hacer una receta.
    2. Ver mis recetas.
    3. Salir.
    """.trimIndent()

    val nombre: String = "Escribe el nombre de tu receta (Ejemplo: Papas Fritas): " +
            "\nO escribe V para VOLVER al menú principal"

    val add = "Escribe el número del ingrediente que quieres añadir:"

    val guardado = "Dato guardado correctamente"

    val ingresa = "Ingresa un dato correspondiente, vuelve a intentarlo"

    val addOtro = "Escribe A para añadir otro ingrediente a tu receta" +
            "\nEscribe G para guardar y volver al menu"

    val unidadDeMedida = "UNIDAD DE MEDIDA. Ejemplo: Litros, Kilogramos, Unidades, etc."

    val cantidad = "CANTIDAD. Solo en números enteros. Ejemplo: 2, 3, etc"

    //Ingredientes predeterminados

    val ingredientes = arrayOf("Agua", "Leche", "Carnes", "Verduras", "Frutas", "Cereales", "Huevos", "Aceite")

    val listaDeCarnes = arrayOf("Cerdo", "Pollo", "Res", "Pescado")

    val listaDeVerduras = arrayOf("Papa", "Zanahoria", "Lechuga", "Tomate", "Cebolla", "Ajo", "Pimenton")

    val listaDeFrutas = arrayOf("Fresa", "Plátano", "Uvas", "Manzana","Naranja","Pera","Cereza")

    val listaDeCereales = arrayOf("Arroz","Maiz", "Avena", "Trigo")

    //Inicio

    var situacion:Int? = menu


    val recetas = arrayListOf("\t\t\tRECETAS: \n")


//      ACCIONES

    fun viewMessage(message:String){
        println(message)
    }

    fun addLiquid(name:String, i:String): String {
        viewMessage(unidadDeMedida)
        val unit:String? = readLine()

        viewMessage(cantidad)
        val volumen:Int? = readLine()?.toInt()

        val liquid = InexactIngredient(name, volumen, unit)
        return i + liquid.toString()
    }

    fun addSolid(name:String, i:String): String{
        var pos = 1
        var especific = "Empty"

        when(name){

            ingredientes[2] ->  {
                for (c in listaDeCarnes){
                    println("$pos $c")
                    pos = pos.inc()
                }

                viewMessage("\n$add")
                val responseA:String? = readLine()

                when(responseA?.toInt()){
                    1 -> especific = listaDeCarnes[0]
                    2 -> especific = listaDeCarnes[1]
                    3 -> especific = listaDeCarnes[2]
                    4 -> especific = listaDeCarnes[3]
                    else -> viewMessage(ingresa)
                }

            }

            ingredientes[3] ->  {
                for (c in listaDeVerduras){
                    println("$pos $c")
                    pos = pos.inc()
                }

                viewMessage("\n$add")
                val responseA:String? = readLine()

                when(responseA?.toInt()){
                    1 -> especific = listaDeVerduras[0]
                    2 -> especific = listaDeVerduras[1]
                    3 -> especific = listaDeVerduras[2]
                    4 -> especific = listaDeVerduras[3]
                    5 -> especific = listaDeVerduras[4]
                    6 -> especific = listaDeVerduras[5]
                    7 -> especific = listaDeVerduras[6]
                    else -> viewMessage(ingresa)
                }
            }
            ingredientes[4] ->  {
                for (c in listaDeFrutas){
                    println("$pos $c")
                    pos = pos.inc()
                }

                viewMessage("\n$add")
                val responseA:String? = readLine()

                when(responseA?.toInt()){
                    1 -> especific = listaDeFrutas[0]
                    2 -> especific = listaDeFrutas[1]
                    3 -> especific = listaDeFrutas[2]
                    4 -> especific = listaDeFrutas[3]
                    5 -> especific = listaDeFrutas[4]
                    6 -> especific = listaDeFrutas[5]
                    7 -> especific = listaDeFrutas[6]
                    else -> viewMessage(ingresa)
                }
            }
            ingredientes[5] ->  {
                for (c in listaDeCereales){
                    println("$pos $c")
                    pos = pos.inc()
                }

                viewMessage("\n$add")
                val responseA:String? = readLine()

                when(responseA?.toInt()){
                    1 -> especific = listaDeCereales[0]
                    2 -> especific = listaDeCereales[1]
                    3 -> especific = listaDeCereales[2]
                    4 -> especific = listaDeCereales[3]
                    else -> viewMessage(ingresa)
                }
            }
        }

        viewMessage(unidadDeMedida)
        val unit:String? = readLine()

        viewMessage(cantidad)
        val volumen:Int? = readLine()?.toInt()

        val solid = InexactIngredient(especific, volumen, unit)
        return i + solid.toString()
    }

    fun addIndividualElements(name:String, i:String) : String {
        viewMessage(cantidad)
        val cantidad:Int? = readLine()?.toInt()

        val element = Ingredient(name, cantidad)
        return i + element.toString()
    }

    fun viewRecipes() {
        for (x in recetas) {
            println(x)
        }
    }

    var final = ""

    fun makeRecipe(){
        var ingrediente = true

        viewMessage (nombre)

        val receta = Recipe()

        when (val name:String? = readLine()) {
            "V" -> situacion = menu
            else -> {
                receta.name = "$name"
            }

        }

        viewMessage(guardado)

        ingredientes@ while (ingrediente) {

            var posicion = 1

            for (element in ingredientes) {
                println("$posicion $element")
                posicion = posicion.inc()
            }

            viewMessage("\n$add")
            val responseI:String? = readLine()

            when (responseI?.toInt()) {
                1 -> final = addLiquid(ingredientes[0], final)
                2 -> final = addLiquid(ingredientes[1], final)
                3 -> final = addSolid(ingredientes[2], final)
                4 -> final = addSolid(ingredientes[3], final)
                5 -> final = addSolid(ingredientes[4], final)
                6 -> final = addSolid(ingredientes[5], final)
                7 -> final = addIndividualElements(ingredientes[6], final)
                8 -> final = addLiquid(ingredientes[7], final)
                else -> viewMessage(ingresa)
            }

            viewMessage (guardado)
            viewMessage(addOtro)

            val responseO:String? = readLine()

            if(responseO == "A"){
                continue@ingredientes
            } else if(responseO == "G"){
                receta.setIngredient(final)
                final = ""
                recetas.add(receta.toString())
                viewRecipes()
                ingrediente = false
            } else {
                viewMessage(ingresa)
                viewRecipes()
                continue@ingredientes
            }

        }
    }

principal@  while (!(situacion?.equals(salir) ?: (false))) {

                viewMessage(inicio)
                viewMessage(opciones)

                val response:String? = readLine()
                situacion = response?.toInt()
    
                if (situacion?.equals(hacer) ?: (false)) {

                    makeRecipe()

        } else if (situacion?.equals(ver) ?: (false)){
                    viewRecipes()
                } else{

                    viewMessage(ingresa)
                    continue@principal

                }
    }
}