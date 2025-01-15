package am.dood.food.menu.domain.model

data class Product(
    val productId: Int,
    val name: String,
    val price: Double,
    val image: String,
    val country: Country,
    val rating: Float = 3.7f,
    val productDetails: ProductDetails,
    val productIngredients: List<ProductIngredient>
)


data class ProductDetails(
    val calories: String,
    val weight: String,
    val preparationTime: String
)

data class ProductIngredient(
    val name: String,
    val icon: Int,
)


