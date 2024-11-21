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
        ),
        ListRecycleMainData(
            id = 16,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1898899/5fb7d956-d5fb-4189-9ec9-1a051aaa7f41/300x450",
            description = "Триггер"
        ),
        ListRecycleMainData(
            id = 17,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/dd78edfd-6a1f-486c-9a86-6acbca940418/300x450",
            description = "Игра престолов"
        ),
        ListRecycleMainData(
            id = 18,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10592371/e2db42c4-4176-4a0f-b933-488412cd06a5/300x450",
            description = "Беспринципные"
        ),
        ListRecycleMainData(
            id = 19,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/ce90ef63-3c81-4aa7-95f0-f5bbe5123484/300x450",
            description = "Монастырь"
        ),
        ListRecycleMainData(
            id = 20,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1629390/f28c1ea2-47b0-49d5-b11c-9608744f0233/300x450",
            description = "Шерлок"
        ),
        ListRecycleMainData(
            id = 21,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4483445/7d26d955-bc98-4731-8ec1-277359f9afa6/300x450",
            description = "Папины дочки. Новые"
        ),
        ListRecycleMainData(
            id = 22,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4486362/3266738a-2614-4ff1-a347-e95f7b90bddf/300x",
            description = "Трудные подростки"
        ),
        ListRecycleMainData(
            id = 23,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1704946/35c2b0c2-742d-4fc4-be2e-aedad582f969/300x",
            description = "Чернобыль"
        ),
        ListRecycleMainData(
            id = 24,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4303601/c2c45ca9-0270-4bb2-bb82-5de3f01effbc/300x450",
            description = "Сверхъестественное",
        ),
        ListRecycleMainData(
            id = 25,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4303601/4639b97f-1ff6-4f63-b7f6-02ea1a14f553/300x450",
            description = "Очень странные дела"
        )
    )
}