package model

class InexactIngredient(name:String?, quantity: Int?, val volumeUnit:String?): Ingredient(name, quantity) {

    override fun toString(): String {
        return super.toString() + "Unidad: $volumeUnit\n"
    }

}