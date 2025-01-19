package am.dood.food.menu.domain.model

import am.dood.food.menu.domain.model.product.Product

data class FoodAssortment(
    val assortmentId: Int,
    val assortment: Assortment,
    val products: List<Product>,
)






