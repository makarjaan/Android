package ru.itis.apphomework2.repository

import android.content.Context
import ru.itis.apphomework2.model.ButtonData
import ru.itis.apphomework2.model.ListData
import ru.itis.apphomework2.model.ListRecycleMainData

object ScreensContentRepository {
    fun getListContent(ctx : Context) : List<ListData> = listOf(

        ButtonData(0),

        ListRecycleMainData(
            id = 1,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/992ac81f-2635-48b2-93fb-f82e01c712d3/300x450",
            description = "Закрытая школа"
        ),
        ListRecycleMainData(
            id = 2,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/fb35416f-3b0d-4b96-bc65-cf6923f9e329/300x450",
            description = "Во все тяжкие"
        ),
        ListRecycleMainData(
            id = 3,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/35c6cb89-75e3-4efa-8d00-5bbf7175c066/300x450",
            description = "Друзья"
        ),
        ListRecycleMainData(
            id = 4,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10703859/478ff41a-bce8-41b7-80b2-cd7b712b6c27/300x450",
            description = "Молодёжка. Новая смена"
        ),
        ListRecycleMainData(
            id = 5,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/eb3ac70c-d99d-471c-89f2-17d1b0978837/300x450",
            description = "Отчаянные домохозяйки"
        ),
        ListRecycleMainData(
            id = 6,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10893610/58239d8d-44d3-475e-ab3f-878679c64290/300x450",
            description = "Слово пацана. Кровь на асфальте"
        ),
        ListRecycleMainData(
            id = 7,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10703959/296c6fed-9ac3-46d2-bf4c-a5fdfa0485e2/300x450",
            description = "Фишер"
        ),
        ListRecycleMainData(
            id = 8,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/37f88226-546b-4779-a074-c92202eb9374/300x450",
            description = "Кухня"
        ),
        ListRecycleMainData(
            id = 9,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/1485ac9a-7796-470b-a3eb-85dc725d4ec0/300x450",
            description = "Король и шут"
        ),
        ListRecycleMainData(
            id = 10,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/47eebe97-9498-4ec9-8e52-3f6330424ede/300x450",
            description = "Мир! Дружба! Жвачка!"
        ),
        ListRecycleMainData(
            id = 11,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/e0afea1f-6e8e-4c9a-aa63-a31ebd3857d0/300x450",
            description = "Мажор"
        ),
        ListRecycleMainData(
            id = 12,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/791d5250-96e7-47ef-a5ea-a791c6e4fe14/300x450",
            description = "Пищеблок"
        ),
        ListRecycleMainData(
            id = 13,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10853012/e65a4287-7631-46b2-b79d-323bed05cf8b/300x450",
            description = "Ивановы-Ивановы"
        ),
        ListRecycleMainData(
            id = 14,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/ce84bf0e-d302-4c64-8404-942f2f0e84c2/300x450",
            description = "Чернобыль: Зона отчуждения"
        ),
        ListRecycleMainData(
            id = 15,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/270df10e-2e72-4d8e-a49b-f84c751162a7/300x450",
            description = "Доктор Хаус"
        )
    )
}