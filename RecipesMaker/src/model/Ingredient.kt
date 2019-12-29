package model

open class Ingredient (val name:String?, val quantity:Int?){

    override fun toString(): String {
        return "\n$name \nCantidad: $quantity\n"
    }

}

