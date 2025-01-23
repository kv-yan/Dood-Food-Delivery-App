package am.dood.food.menu.domain.model.product

sealed class ImageSource {
    data class Url(val url: String) : ImageSource()
    data class Resource(val resId: Int) : ImageSource()
}
