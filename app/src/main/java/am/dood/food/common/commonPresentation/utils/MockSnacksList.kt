package am.dood.food.common.commonPresentation.utils

import am.dood.food.menu.domain.model.Country
import am.dood.food.menu.domain.model.product.ImageSource
import am.dood.food.menu.domain.model.product.Product
import am.dood.food.menu.domain.model.product.ProductDetails
import am.dood.food.menu.domain.model.product.ProductType

private val fileProductType = ProductType.SNACK

// TODO: write a normal list
val snacksAssortment = listOf(
    Product(
        productId = 0,
        name = "Burger With Kyufta",
        price = 15.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/3cbc/a5cf/d3466f4f3a121c9867c8de88159afd31?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ScSupaphVOJmy5nFc3b0PRXXZkyXyb1lX5gYt5Pe8Tkz28AR4iiNBt3-ebkWCz3jfrrTGg0YnO-dbeLPko1-w4D5OE~QycM7IinUNgHY6yrWN0eYhMCn047CTrEVdcFd6MxrxCYEJw-vumRRqHPAx-KaCVSZktjn6~QVT9hnu54tUJUcaDeOB7gSvIib9SpLVvIpqUh60pYEccRkF2fnsvFAxZ8tx-9EaH-VAnEOm~~Swtk65ZDhDks-Uiw2foaHQp-AUyhTmfjvRe5OaBaWJUFSalVFpb9zIMBXDkMdVQCQjN2vx07h8Bu0MarOPVayCQsIgt6v9ImQqDV3P1mz3A__"),
        rating = 4f,
        country = Country.ITALY,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 1,
        name = "Cheeseburger",
        price = 13.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/49fd/faeb/aa3f76b5b824a4d15a620df942216f2f?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YHYPT6S3ThMEM95wxvJNGG2dCvXoJNMxuRoryOhB2wJij34CWpsx0almv8iPu4aTq3YoooSX-rZlsRqa3HxnwdUTN-yh-WucVjlMUAsgbATx57j2nTacf3v2R928N8ck4MvF02m~~gHvIL0bFftHPVOKzMv8hn-8EV-7ahfY9SGJC3F0qMHCJCdaiWEHlnUzHSFVcoDplz1CmqNtkJA8U8Eo7NhOLnr5WRQlVQs9sEiqzF3kShzZoRNaLb~-xD1p9Q3RPD6GUIXIbMY~GiyQC4wW2IjHXNqdUISQM9LkTBicSjj6E1c03~8U7HlqwUv21aUZvnhHwwDvviTgKC00nw__"),
        rating = 4f,
        country = Country.AMERICA,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 2,
        name = "ChickenFillet",
        price = 7.8,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/ba34/a2ce/0862a5a087e7ffd164ff4d39c3f8b956?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=R5hqgK2sHTrlH31yhgFW2ZDG~eqwCTVjXlrJ5XaFA6z~m041qpkNggOqDdCYttwBgW7DduAm~TVZa-h9glEXZ9nTf7VWVkPFyZVGu4tQQ8WKM36WOSvV2u3K7shCgzUwNarQINth4FQwnYxsRIAXgJnQgesVHt9O1X5xR-iw8jiI9vD5fr7KEG-GYx8xbA8GvLdgwgiOum-JgZ6vhyxxBwS9Xmv2VwRxMuHeajcuIek60RAT-vwEkkZzkkHl2b6G-2VP1Teyd74BmVL4YZnrdOclG3eE2HPd1x4MxMhsXz2WA462pFannQ5J0kt-Gk0LJ0mDylFJDfAQRDy8WWuKag__"),
        rating = 4.2f,
        country = Country.ITALY,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 3,
        name = "ChickenBurger",
        price = 13.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/c434/1380/adcddd4e32c6613d8fd3d98e191b01fd?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=nK9mk6bLL3vtvQ3Pjjjm0ADuDSIOeKyYhuwVryn-K~VrOM2O5Am4hU2yN1yJg2T-vFduFIR9mGCVKrODzv6jjRxj9IMoMvFIpPNckvDWgA8mwb83RZ8CPbMlGikcHfvQYZzSTnbmEkkmJDKcA7ntxg-0YQbdrzxtr7OBeSovAgzijBfuNwX7iRvadpCtMjanb53A5zyUjZw3Y7SNJ2a0VSfRRs17XtU0hSuVtgKyWCMv0pVN538-mSpNePgBnNFyXMRsBpLG7pkE0BKhE2vHoG3jrhMrokFxBBEfBq7CaOHlh0FPKeF-m8DYq0dNXSi49tmDNnV4sM8Kue4oMEtR8g__"),
        rating = 4.2f,
        country = Country.ITALY,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 4,
        name = "Margarita",
        price = 13.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/12f3/121d/d22ae83a47375e094a7782e8c33c9d5f?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=DFiv3E2WdQ~tunynWzBYVwuioB7pmicBdUSkvdwXtctUjiZpV4iGHt~G~FOt3I3q3e93oGCTXsidJEhZpb19Sds0uFd68zmu0JCWSbv8Q0cz3vfB9bz6Opx6LcbZoWjNQzt-d0sU5W0W1IFSVjzhS290tId4SgQxEXuXJOGbMMHd0TCR35iVfJ7HV7e49i4Y-uvWrnNJAmyzFijP9LdcSPTYt-C1q0BG0rcnqT9NE1GBCRMLp6-v3yEoYQJTJReWGTR~ljZuedvIMC5GlRITkwnLuw5~tN4hIUiL~8qgYdLSTSiLmy7Yod6h7tooOoGOTCcQK14wBiWoBdcGu20zdw__"),
        rating = 4.2f,
        country = Country.ITALY,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 5,
        name = "New York",
        price = 13.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/e42d/3075/0b17fc3fe994efc64e14d551f765173c?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=APHza9-vPh8rvY7Ed3S4~aznAKJbMdESub2anHkrvlBkpOteocslSSyXyZNVDC8M3XpLdJYst535L0q1OXsQnz4dNwansp~TAgp1pWxp5Kl8HVEZkOpKtd1czm-ZsYyYHh~21VfDS4-WgLhh2mBgIJgna7FO9nSXziD2iUoSYZiX7IVPj6BIaBAYYXbixoRDvpKP3OoCrHLIVJ5jj1OQewbert9Za5-LjR7pZgQGlRVXmFPbDpMkexs5gkjBwWEWkWxWIxSt~PzT4Q8l2Rx5IgP8~YqeNcMSqK8-8nw9L4XkqLRNENFjZalwZMuMGzr7NwtTttWBX230GeqhDJVXRw__"),
        rating = 4.2f,
        country = Country.ITALY,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
    Product(
        productId = 6,
        name = "Toppings",
        price = 13.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/5c81/e1a6/df6a9b27de4f7665abe82013787f6017?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=CS6MhfP6laOVoFdNVnT4Xc5UEN4WVhcOPyJXCNc2CejPebT-I7aM-1w6VBLLB6ehF0eKh8fQh3U3Hgw6c3Ve~ByvrVX~Kol4n9KMdN54jFV4O0YroXjP79344NT23erSXzwXAKMaValgV99t35m80nYWjke8FohNl31aBJ28mv07C9iOJgWzQfiJus9Uy-PiUg-DwsIDtS7bP5znnRa750nmdutsWHQqXiyfuYROiZs5UPzOntdm1Q7wRQOJ5mYYydp07DijGMvu1LcbH3qeRdxIO8qpWHJoEGNloKTj02bnRnonU6konIZ6co8-dQQGX5CTFHSTSSSxUJnGr3uJcg__"),
        rating = 4.2f,
        country = Country.ITALY,
        productType = fileProductType,
        productDetails = ProductDetails(
            calories = "125 kkal",
            weight = "120 gr",
            preparationTime = "20 min"
        ),
        productIngredients = productIngredients
    ),
)

