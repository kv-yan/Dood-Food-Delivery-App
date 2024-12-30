package am.dood.food.menu.domain.usaCase

import am.dood.food.common.commonPresentation.utils.appAssortment
import am.dood.food.menu.domain.model.FoodAssortment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface GetAssortmentsUseCase {
    operator fun invoke(): Flow<List<FoodAssortment>>
}

class GetAssortmentsUseCaseImpl : GetAssortmentsUseCase {
    override fun invoke(): Flow<List<FoodAssortment>> = flowOf(appAssortment)
}