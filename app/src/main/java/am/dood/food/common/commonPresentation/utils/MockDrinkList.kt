package am.dood.food.common.commonPresentation.utils

import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.product.ImageSource
import am.dood.food.menu.domain.model.product.Product
import am.dood.food.menu.domain.model.product.ProductType

private val fileProductType = ProductType.DRINK

val drinkAssortment = listOf(
    Product(
        productId = 0,
        name = "7 Up",
        price = 2.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/6175/9513/5b1606bb6a497823717a89340d77eb59?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LtzQ2T1dsSFVkHJWIKQCXgS4srmoMX4FcBnBqoq7kXKFaSWwoK2wJdntvy482NO4JAGvQz1WvPP8psAwK6VS6pmYVPccs5RFp55Jj~T1BoAGj3xDV1nPRR8n-y2zta6p1GtmPGheDYi6~AJxqDHHtg1fh9basa57e-Iy2TQtBtIlA3-b0OpjPTbShvdF19lH9zczClI6Xe8pGAQ72OcUBjhjHlMCbRfjU02Xlxdpks6-g67QJ6aJbgDZmhS-0XcZ-iNPu3w9OuGsgO4ynBQIFoTUs5HDPAlLojKqW73Y1PUjYYT1l2iRZGgI-ssPRMmPetVFgkuu8XABYjj8E-YAyg__"),
        rating = 4f,
        country = Country.AMERICA,
        productType = fileProductType,
    ),
    Product(
        productId = 1,
        name = "Fanta",
        price = 2.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/6984/ec44/0f4b6e07a0b2d6b9494a78e998987926?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=n8vZBRd5vBwZZ-l19-alXPiSzPE-DxnjsmmA6kmevYlYiiK5fyBbKLSeD0KqutLnsTZWSWGxF3NB8U5YGcWcbRXKH54S2O7MfIec8kq1E0tmXoNVn7uDVrrlYpHnRYPFYul11rVxAjEQIJ~HUamRvUXnsB-2P8rYxELdO1IYAgmUBysMFNB5PDun9jWCvbA3Y3K9etg4C13Fln6jFLjiLl2B3uMVCPzblpf6i0e4GeLbUKPiU7ykFpMtoM56lGA5naSY3EEWJ~ibViacpZ87cR0pJCbb1o7QNFkHlA3eSKTS~mzWQJnN5aeTdXd8ujXrGB6fKHrV8gNJ2K~HS9DZbg__"),
        rating = 4f,
        country = Country.AMERICA,
        productType = fileProductType,
    ),
    Product(
        productId = 2,
        name = "Coca-Cola",
        price = 2.5,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/d343/8fec/ad7901221aba83e58c5b83c13da19083?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=qqBnP3dRXyAy3pwzZZm6Rceb4OHQApnEaAW4-c1wji5tjczRbYEoQTNTHceFSjt43aBrFNP07pM6w56j~D6qurYQjkZr-otG~LZsYtjywsyHDV6narbX4wX1nh~3oXcstetl7m5YrgrEzfCqq03PAfYSaCBJtt6zTxPgCaTOi4EVtP9ODCftbcR~GUObmQ0vwRxdFyl-T~XzpyR2~YWZo1CU1vsXY2Jh4zKQnhXOE4cHYnNllJDfaQ8SFf70FJ2CBri8tMM3CGXG9~GR7TPhbWoLL5gzhl6LPhHqhfcpYgYLlNw514s1UQVkmXPy9bBpYXCMme4IFgLNbOsGaCbA1w__"),
        rating = 4.2f,
        country = Country.AMERICA,
        productType = fileProductType,
    ),
    Product(
        productId = 3,
        name = "Pepsi",
        price = 2.5,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/2c23/5bb5/b4857be2363969d246dbf44bc9ff6568?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=TJfcYLOK4iZbZfESOPhRSW3mmFc9ZC7YnoDpPfjofYbi3TtLTvVpcAx-LgxliCm3Ii033I9HAmCBCGpfm4zI2Ci9VCbcGWibrNccBPued08okwfL3Si8qFaVnXc-zbZLiNGJEECOx0khpTkN6VUZeEea2uurY2Geohe57pXsKbkDATi6CV192XAE4xZiLqCEYnx1JImD31LvxJ8gij6NZwCQpoRj8icjsZbXFZm7GKh4WDdCUmc69RmEu7K6IWujnXLu86Dp28oHsn9hzVkAXMxkJSYFAoT~rQJnkfKCCjVSaxKslb2GX5E-89W3h6ojDF1ac59xVUnMgM387rCZ2w__"),
        rating = 4.2f,
        country = Country.AMERICA,
        productType = fileProductType,

        ),
)

