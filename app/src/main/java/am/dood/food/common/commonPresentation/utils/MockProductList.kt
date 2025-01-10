package am.dood.food.common.commonPresentation.utils

import am.dood.food.R
import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.Product
import am.dood.food.menu.domain.model.ProductDetails
import am.dood.food.menu.domain.model.ProductIngredient

private val productIngredients = listOf(
    ProductIngredient(
        name = "Flour",
        icon = R.drawable.ic_flour
    ),

    ProductIngredient(
        name = "Mozzarella",
        icon = R.drawable.ic_mozzarella
    ),

    ProductIngredient(
        name = "Pepperoni",
        icon = R.drawable.ic_peperoni
    ),


    ProductIngredient(
        name = "Tomato sauce",
        icon = R.drawable.ic_tomato_sauce
    ),
)

val pizzaAssortment = List(10) {
    Product(
        productId = it,
        name = "Pizza $it",
        price = 10.0,
        image = "https://s3-alpha-sig.figma.com/img/ba34/a2ce/0862a5a087e7ffd164ff4d39c3f8b956?Expires=1737331200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=TJn1oKVnAREmI~bHlKhUgTRmkYPqwzcCt93t9uYrggfU65WesDYwdKC5OZMgGnoYDf-tr6DhO~kGyqcRV9RQnjIFFGI0UfXw6wr9uYS8yGMQFJoz2OvMfCZ8pEmvNW2uFGVglPRLLLe8ke75uTwWJbNsnwQrSv8eSTIERsLWJ~bfrRIw-hW~tQASS8PGppmosV5VBRgVrtIf4h2QfImQ5o16u7jS5D9QiEfV7vW-tXcTTFkAHtJnCCdxuwRlR6aLZ5vMAAmTeFjlPC3gFOjzD1PkWusC5upOgeIFHDINv2Df74q9P7wE3DaBziRd4h3~gDvOqu4qmYRbd9YHgIxghg__",
        country = Country.ITALY,
        rating = 3.7f,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    )
}
