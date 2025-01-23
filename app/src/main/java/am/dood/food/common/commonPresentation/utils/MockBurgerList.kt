package am.dood.food.common.commonPresentation.utils

import am.dood.food.R
import am.dood.food.menu.domain.model.product.ImageSource
import am.dood.food.menu.domain.model.product.Product
import am.dood.food.menu.domain.model.product.ProductDetails
import am.dood.food.menu.domain.model.product.ProductType


private val fileProductType = ProductType.BURGER

val burgerAssortment = listOf(
    Product(
        productId = 0,
        name = "Gyros burger",
        price = 15.0,
        image = ImageSource.Resource(R.drawable.burger_gyros),
        rating = 4f,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 1,
        name = "Double burger",
        price = 15.0,
        image = ImageSource.Resource(R.drawable.burger_double),
        rating = 4f,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 2,
        name = "Nuggets burger",
        price = 15.0,
        image = ImageSource.Resource(R.drawable.burger_nuggets),
        rating = 4f,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 3,
        name = "Big Sanders burger",
        price = 15.0,
        image = ImageSource.Resource(R.drawable.burger_big_sandres),
        rating = 4f,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 4,
        name = "Sanders burger deLux",
        price = 15.0,
        image = ImageSource.Resource(R.drawable.burger_sandes_de_lux),
        rating = 4f,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),    Product(
        productId = 5,
        name = "Big Sanders burger deLux",
        price = 15.0,
        image = ImageSource.Resource(R.drawable.burger_big_sandes_de_lux),
        rating = 4f,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
)

