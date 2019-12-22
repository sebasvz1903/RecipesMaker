fun main() {

//      DECLARACIONES

//Situaciones:
    val menu = 0
    val hacer = 1
    val ver = 2
    val salir = 3

//Strings:
    val inicio = "\n:: Bienvenido a Recipes Maker ::\n"

    val opciones: String = """
    Escribe el número correspondiente a la opción deseada:
    1. Hacer una receta.
    2. Ver mis recetas.
    3. Salir.
    """.trimIndent()

    val nombre: String = "Escribe el nombre de tu receta (Ejemplo: Papas Fritas): " +
            "\nO escribe V para VOLVER al menú principal"

    val a = "Agua"
    val l = "Leche"
    val c = "Carne"
    val v = "Verduras"
    val f = "Frutas"
    val ce = "Cereal"
    val h = "Huevos"
    val ac = "Aceite"

    val ingredientes = listOf(a, l, c, v, f, ce, h, ac)

    val add = "Escribe el número del ingrediente que quieres añadir:"

    val guardado = "Dato guardado correctamente"

    val ingresa = "Ingresa un dato correspondiente, vuelve a intentarlo"

    val addOtro = "Escribe A para añadir otro ingrediente a tu receta" +
            "\nEscribe G para guardar y volver al menu"

    var situacion:Int? = menu

    val recetas = mutableListOf("\tRECETAS: \n")

//      ACCIONES

    fun viewRecipes(){
        println(recetas)
    }

    fun makeRecipe(){
        var ingrediente = true

        println (nombre)

        when (val name:String? = readLine()) {
            "V" -> situacion = menu
            else -> recetas.add("\n\n$name: \n")
        }

        println(guardado)

        ingredientes@ while (ingrediente) {

            var posicion = 1

            for (element in ingredientes) {
                println("$posicion $element")
                posicion = posicion.inc()
            }

            println("\n$add")
            val responseI:String? = readLine()

            when (responseI?.toInt()) {
                1 -> recetas.add("- $a -")
                2 -> recetas.add("- $l -")
                3 -> recetas.add("- $c -")
                4 -> recetas.add("- $v -")
                5 -> recetas.add("- $f -")
                6 -> recetas.add("- $ce -")
                7 -> recetas.add("- $h -")
                8 -> recetas.add("- $ac -")
                else -> println(ingresa)
            }

            println (guardado)
            println(addOtro)

            val responseO:String? = readLine()

            if(responseO == "A"){
                continue@ingredientes
            } else if(responseO == "G"){
                println(recetas)
                ingrediente = false
            } else {
                println(ingresa)
                println(recetas)
                continue@ingredientes
            }

        }
    }

principal@  while (!(situacion?.equals(salir) ?: (false))) {

                println(inicio)
                println(opciones)

                val response:String? = readLine()
                situacion = response?.toInt()
    
                if (situacion?.equals(hacer) ?: (false)) {

                    makeRecipe()

        } else if (situacion?.equals(ver) ?: (false)){
                    viewRecipes()
                } else{

                    println(ingresa)
                    continue@principal

                }
    }
}