package am.dood.food.common.commonPresentation.utils

import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.Product

val pizzaAssortment = List(10) {
    Product(
        productId = it,
        name = "Pizza $it",
        price = 10.0,
        image = "https://s3-alpha-sig.figma.com/img/3cbc/a5cf/d3466f4f3a121c9867c8de88159afd31?Expires=1736121600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EJ2guOxJI9p5166pCTSsNXoffQHTlmGxnO9Mo7He19gFJbmAxsiE5MmXDuRBNx9GqUxAXWKhVphvBQoGQF0rLpnbDQHw73w75jEjhLVErt5ortSqN4c4E8BP2wycZjHGa6KpqnqqHszQXc9hD8ND~EEjKlgwG~3IfAQpVfBtZtAXpt2z4NrOq0SsFJr8MStjOU8t-oUkMm~d-zr-yUALBCvpkCe8YYnPqfrkLLLEF3RDKrUayl49Fc6VtWU7Ka4wNY-p3S1FYssg~WwQvrQfCMHSWYURiio9tR~hviBt8ld1IuMGaWSSqBQ965t4EdD7fz1P5q~5jWnzjpvzAz37rQ__",
        country = Country.ITALY
    )
}
