package am.dood.food.common.commonPresentation.utils

import am.dood.food.menu.domain.model.product.ImageSource
import am.dood.food.menu.domain.model.product.Product
import am.dood.food.menu.domain.model.product.ProductType

private val fileProductType = ProductType.SALAD

val saladesAssortment = listOf(
    Product(
        productId = 0,
        name = "Caesar Salad",
        price = 7.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/b3b1/d024/85789e9458c1af675955136406e62b06?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=E-b3mY0RJkhFlO-35vgzBKSvA2XCHC5ZqjQhISokdC3AatLN7xyqfKkQ~JIh2mVlBVtE3ksAb0yZgByxhpnUYlAzLAWdBsKCsB3rBjFEEfyz5PorAgGJEYrjxJdXFlRPcljEl2timnQyYhIuaBlUD1P5P5Q0gOSR7l78vWab72aXtml3VOMtSjRHU8QNqljgD2hGu9DF7k7XM~FRu5wvxI~l6EvUuqAOPbOdoBknBCeHyrUOZGWWvPd5VrlywRU7e9i93L4OSacAgOxbIdFcs4DKIyG38NQriCAvLnPc7FuJYdjR2ArmWrNV06nOFwquC6lc8MiapHxUeArphXOXLg__"),
        rating = 4f,
        productType = fileProductType,
    ),
    Product(
        productId = 1,
        name = "Fatush Salad",
        price = 6.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/6f34/9e0c/00add4efddc134d521f58cc4bd07c5f5?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=i96q0Xn~mwKj3dgppPGd4asBiWDm5xwrL8ssC0KFGTz2xV97pnyR15v-F4JcW5SicvmFWaKrDwn8-mgxOFvAlY-JNafZE3LTcvAqMcabXxKc-M-4uUetK9HtLnFzNwNvT0KvMklsQoNy22KFH2~v5Ln5ZtEtO-d7b0C0zCoNkmcpSAFh4flo9J-6UD5hQDB03vytQu0t2nvsFKxipI42jwwx06uYsSC3uDweRHIcYArkWaJeCV8a7RpdhhZbAXsveqtspS06FQtz1DJH~L9LhWyoIk9NwZqHLqAH7b-hZYIO95B0TmL5hJDQ5tQA-W0e7lqqpKm2x7BMsLXT-6Y6Sw__"),
        rating = 4f,
        productType = fileProductType,
    ),
    Product(
        productId = 2,
        name = "Greek Salad",
        price = 8.0,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/f967/7bed/eefc4054d9b7ac3bb73956594c67cded?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=dM~bXK9fOVe9G5ruNbFX~KXf6pOSeDz-AsMqgPrVknr~tB~Ep2SMS6R6S9J6I8i75AYHpqgVqDkgDfgYSuV-gwz3wywoRI51cSzIja3ni~tZWxKhzF1aKuseTevmOsEarPoDP19COKLWuPkJmfRlko~Y81ed6GVsGSGYuQRjd2NahFvMZszD42~gneVpP0h-8ssSdob9eNfefmsumNRoPsa9el3XVyJy35AyTEvqiobBfIYNrHovRhtsKgtr9t2D0Bu4or1S9vDZO6k3ACfeLcWnQW3aFTR-DuF24X0yKDZq5p7zHkkBdJUreWlQtGihEbFD0Ua8EB~T16RBQyw6cg__"),
        rating = 4.2f,
        productType = fileProductType,
    ),
    Product(
        productId = 3,
        name = "Sicilian Salad",
        price = 7.5,
        image = ImageSource.Url("https://s3-alpha-sig.figma.com/img/f173/ad1e/061c89c545cfe4e0215242205dc9bb10?Expires=1738540800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=XlGw1yRAn0kKs2-aDPyqTz-gdfvg9TkLqicJt0rh3i4SEW9VP2JB-hfa4KyudXSl~9zyzBN5e2exl9x7Apvd7i-wpJNt1gLLz6beab9-9jitJNxH9rNda9iRd9MwOKI-QMxra2o~am6xcul-mI8yETmLKEiqMna4USDLRVOQCymL2zPOvyZQvYqykcwPYV8EmLRAJGJNSiT3~uI2Dlt0s~aPBOBl7VfwyTD8m~c2a~mtQ1srB76V~A36oYoYYfylORbliVjGl8j0YB9unLqZgq4Iv-nI~9a5BndsVkraVxqU2qWArWzhykbjnzRWPPRmeFOnuZAX~Q0LNn1nEq8MXg__"),
        rating = 4.2f,
        productType = fileProductType,
    ),
)

