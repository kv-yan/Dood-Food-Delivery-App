package am.dood.food.common.commonPresentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class MainViewModel : ViewModel() {
    private val _isDarkTheme = MutableSharedFlow<Boolean>(2)
    val isDarkTheme = _isDarkTheme.asSharedFlow()

    fun setDarkTheme(isDarkTheme: Boolean) = _isDarkTheme.tryEmit(isDarkTheme)
}