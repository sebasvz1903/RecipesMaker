package model

class Recipe (var name: String = "Empty", var ingredients: String = "\n") {

    fun setIngredient(new:String){
        ingredients += new
    }

    override fun toString(): String {
        return "\n\t ///// $name ///// \n \nIngredientes: $ingredients\n"
    }
}