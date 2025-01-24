package am.dood.food.menu.domain.model.product

import am.dood.food.menu.domain.model.Country

data class Product(
    val productId: Int,
    val name: String,
    val price: Double,
    val image: ImageSource,
    val country: Country? = null,
    val rating: Float = 3.7f,
    val productType: ProductType = ProductType.OTHER,
    val productDetails: ProductDetails? = null,
    val productIngredients: List<ProductIngredient>? = null
)


