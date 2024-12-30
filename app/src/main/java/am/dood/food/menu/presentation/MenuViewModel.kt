package am.dood.food.menu.presentation

import am.dood.food.menu.domain.model.FoodAssortment
import am.dood.food.menu.domain.model.Product
import am.dood.food.menu.domain.usaCase.GetAssortmentsUseCase
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MenuViewModel(
    val getAssortmentsUseCase: GetAssortmentsUseCase
) : ViewModel() {
    private val _screenState = MutableStateFlow<MenuScreenState>(MenuScreenState.Loading)
    val screenState: StateFlow<MenuScreenState> = _screenState.asStateFlow()

    private val _selectedAssortment = MutableStateFlow<FoodAssortment?>(null)
    val selectedAssortment: StateFlow<FoodAssortment?> = _selectedAssortment.asStateFlow()

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct.asStateFlow()

    private val _isShowingScreen = MutableStateFlow(false)
    val isShowingScreen: StateFlow<Boolean> = _isShowingScreen.asStateFlow()

    init {
        fetchAssortments()
    }


    fun setShowingScreen(boolean: Boolean) = run { _isShowingScreen.value = boolean }

    fun selectAssortment(item: FoodAssortment) = run { _selectedAssortment.value = item }

    fun selectProduct(item: Product) = run { _selectedProduct.value = item }

    private fun fetchAssortments() {
        val scope = CoroutineScope(Dispatchers.IO)
        getAssortmentsUseCase().onEach {
            _screenState.value = MenuScreenState.Success(it)
            if (it.isEmpty()) {
                _screenState.value = MenuScreenState.Error("No data")
            }
        }.catch {
            _screenState.value = MenuScreenState.Error(it.message ?: "Unknown error")
        }.launchIn(scope)
    }

}
