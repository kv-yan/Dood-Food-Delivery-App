package am.dood.food.common.commonPresentation.utils

import am.dood.food.menu.domain.model.Assortment
import am.dood.food.menu.domain.model.FoodAssortment

// TODO: write normal mock data
val appAssortment = listOf(
    FoodAssortment(
        assortmentId = 1,
        assortment = Assortment.PIZZA,
        products = pizzaAssortment
    ),
    FoodAssortment(
        assortmentId = 2,
        assortment = Assortment.BURGER,
        products = burgerAssortment
    ),
    FoodAssortment(
        assortmentId = 3,
        assortment = Assortment.NUGGETS,
        products = nuggetsAssortment
    ),
    FoodAssortment(
        assortmentId = 4,
        assortment = Assortment.SNACK,
        products = snacksAssortment
    ),
    FoodAssortment(
        assortmentId = 5,
        assortment = Assortment.SALAD,
        products = saladesAssortment
    ),
    FoodAssortment(
        assortmentId = 6,
        assortment = Assortment.DRINK,
        products = drinkAssortment
    ),
)