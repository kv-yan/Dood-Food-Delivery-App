package am.dood.food.menu.domain.model

import am.dood.food.R

enum class Assortment(val type: String, val icon: Int) {
    PIZZA("Pizza", R.drawable.ic_pizza),
    BURGER("Burger", R.drawable.ic_burger),
    NUGGETS("Nuggets", R.drawable.ic_nuggets),
    SNACK("Snack", R.drawable.ic_snack),
    SALAD("Salad", R.drawable.ic_salad),
    DRINK("Drink", R.drawable.ic_drink),
}
