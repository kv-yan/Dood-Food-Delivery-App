package am.dood.food.menu.domain.model

data class Product(
    val productId: Int,
    val name: String,
    val price: Double ,
    val image: String,
    val country: Country,
    val rating: Float = 3.7f,
)
