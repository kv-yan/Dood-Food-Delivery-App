package am.dood.food.menu.presentation

import am.dood.food.menu.domain.model.FoodAssortment

sealed class MenuScreenState {
    data object Loading : MenuScreenState()
    data class Success(val assortment: List<FoodAssortment>) : MenuScreenState()
    data class Error(val message: String) : MenuScreenState()
}