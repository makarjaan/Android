package ru.itis.apphomework2.repository

import android.util.Log
import ru.itis.apphomework2.model.ListData
import ru.itis.apphomework2.model.ListDetailedData
import ru.itis.apphomework2.model.ListRecycleMainData

class ScreensDetailedContentRepo() {

    private var listInfo = listOf(
        ListDetailedData(
            id = 1,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/992ac81f-2635-48b2-93fb-f82e01c712d3/300x450",
            headerText = "Закрытая школа",
            infoText = "Сериал рассказывает о жизни учеников и преподавателей элитной школы-интерната, расположенной в старинной усадьбе посреди мрачного, но живописного леса. В их замкнутом мире все переживания намного острее, чем в обычной школьной жизни. Несмотря на внешнее благополучие, ребята, оторванные от родного дома, очень ранимы и зачастую одиноки. По вечерам они рассказывают друг другу страшные легенды о лесе, глухой стеной окружающем их школу, говорят, будто в нем водятся странные существа и бесследно пропадают люди. Очень скоро ребята узнают, что правда гораздо страшнее легенд."
        ),
        ListDetailedData(
            id = 2,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/fb35416f-3b0d-4b96-bc65-cf6923f9e329/300x450",
            headerText = "Во все тяжкие",
            infoText = "Школьный учитель химии Уолтер Уайт узнаёт, что болен раком лёгких. Учитывая сложное финансовое состояние дел семьи, а также перспективы, Уолтер решает заняться изготовлением метамфетамина. Для этого он привлекает своего бывшего ученика Джесси Пинкмана, когда-то исключённого из школы при активном содействии Уайта. Пинкман сам занимался варкой мета, но накануне, в ходе рейда УБН, он лишился подельника и лаборатории."
        ),
        ListDetailedData(
            id = 3,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1900788/35c6cb89-75e3-4efa-8d00-5bbf7175c066/300x450",
            headerText = "Друзья",
            infoText = "Шестеро друзей – Рейчел, Моника, Фиби, Джоуи, Чендлер и Росс – живут по соседству, вместе убивают время, делятся секретами и иногда очень сильно влюбляются."
        ),
        ListDetailedData(
            id = 4,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10703859/478ff41a-bce8-41b7-80b2-cd7b712b6c27/300x450",
            headerText = "Молодёжка. Новая смена",
            infoText = "Команда Студенческой хоккейной лиги «Акулы Политеха» на грани расформирования. Но в вуз приходит Казанцев, который решает превратить «Акул» в лучшую команду лиги и тем самым повысить рейтинг института. Тренером клуба он видит в первую очередь бывшего игрока «Медведей» — Андрея Кисляка. Чтобы вывести «Акул» на следующий уровень, Кисляку придётся не только найти общий язык с новым поколением спортсменов, но и измениться самому."
        ),
        ListDetailedData(
            id = 5,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/eb3ac70c-d99d-471c-89f2-17d1b0978837/300x450",
            headerText = "Отчаянные домохозяйки",
            infoText = "В центре событий - четыре современные домохозяйки, которые живут в тихом пригороде и отчаянно ищут личного счастья. Сьюзан осталась одна после того, как муж променял её на секретаршу. Бывшая фотомодель, а ныне неверная жена, Габриель вышла замуж по расчёту, а потом поняла, что нуждается не в деньгах, а в настоящей любви, и завела роман с юным садовником. Бри пытается сохранить разваливающийся брак и найти общий язык с сыном-наркоманом и слишком рано повзрослевшей дочерью. Линнет поставила крест на блестящей карьере в крупной компании, чтобы посвятить всё свое время воспитанию детей. Внезапное самоубийство их подружки Мэри Элис Янг оставляет всех в недоумении и заставляет искать разгадку ее смерти..."
        ),
        ListDetailedData(
            id = 6,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10893610/58239d8d-44d3-475e-ab3f-878679c64290/300x450",
            headerText = "Слово пацана. Кровь на асфальте",
            infoText = "Казань, начало 1989 года. Пока родители борются за выживание, подростки сбиваются в уличные банды и бьются за асфальт. Буквально, чтобы контролировать всё, что стоит на «их» земле или передвигается по ней. Среди всеобщей нищеты — чёткие правила жизни, поддержка и слово пацана, которое сильнее клятвы. 14-летний Андрей из интеллигентной семьи, он учится в музыкальной школе и живёт с мамой и маленькой сестрёнкой. Однажды парня назначают подтянуть по английскому сверстника Марата — гопника из местной группировки. Пообщавшись с нормальным пацаном и решив, что ему надоело быть чушпаном, Андрей вступает в банду."
        ),
        ListDetailedData(
            id = 7,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10703959/296c6fed-9ac3-46d2-bf4c-a5fdfa0485e2/300x450",
            headerText = "Фишер",
            infoText = "1986 год. В районе правительственных дач на Рублевском шоссе одного за другим убивают подростков. Интеллигентный следователь Валерий Козырев, его дерзкий напарник из Ростова Евгений Боков и совсем молодая следователь Наталья Добровольская начинают расследование, даже не подозревая, как сильно оно изменит судьбу каждого из них. Единственный свидетель, способный опознать маньяка, — школьник Игорь, родители которого совсем не в восторге от контактов сына с милицией."
        ),
        ListDetailedData(
            id = 8,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/37f88226-546b-4779-a074-c92202eb9374/300x450",
            headerText = "Кухня",
            infoText = "«Во все времена еда была рядом с людьми. Она искушает, вдохновляет, восхищает, отвращает. Но человек не может без еды, а значит тот, кто создает еду, может управлять миром...». Так думал Максим Лавров, когда шел осуществлять свою мечту – устраиваться поваром в один из самых дорогих ресторанов столицы. Мечта сбылась, вот только на деле все вышло не так вкусно. Шеф-повар ресторана Виктор Баринов – настоящая звезда гастрономического бомонда, знающая как угодить взыскательной публике. Оборотная сторона этого идеального образа – злоупотребление алкоголем, страсть к азартным играм и невыносимый характер. В гневе Баринов страшен, в загуле – неукротим..."
        ),
        ListDetailedData(
            id = 9,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/1485ac9a-7796-470b-a3eb-85dc725d4ec0/300x450",
            headerText = "Король и шут",
            infoText = "Горшок, Князь и Шут — герои панк-сказки, в которой студенты реставрационного училища стали одной из главных рок-групп страны, собрали «Юбилейный», покорили Москву, выступили как хедлайнеры на фестивале «Нашествие» и создали целую фэнтези-вселенную. Группа вошла в историю, а тексты их песен ожили в мире-фантазии, где Горшок и Князь отправляются спасать принцессу из плена колдуна."
        ),
        ListDetailedData(
            id = 10,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/47eebe97-9498-4ec9-8e52-3f6330424ede/300x450",
            headerText = "Мир! Дружба! Жвачка!",
            infoText = "1993 год. 14-летний Санька Рябинин живет обычной подростковой жизнью — ищет приключений, пытается защититься от районных хулиганов, не хочет ходить в музыкалку, не знает, как общаться с девчонками и с кого из взрослых брать пример. С одной стороны — честная, но бедная семья с мамой-продавщицей и папой-доцентом, с другой — опасный мир афганского ветерана дяди Алика. А тут еще и девочка Женя, знакомство с которой запускает череду необратимых событий, которые навсегда изменят жизнь Саньки, его семьи и друзей Вовки и Илюши. Сбегая от хулиганов, Санька угоняет машину местного криминального авторитета, и в один миг все меняется..."
        ),
        ListDetailedData(
            id = 11,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/e0afea1f-6e8e-4c9a-aa63-a31ebd3857d0/300x450",
            headerText = "Мажор",
            infoText = "Таких, как наш главный герой Игорь Соколовский, то есть детей высокопоставленных, богатых родителей, называют мажорами. Наш герой имеет юридическое образование, но ни одного дня не проработал. Безответственный прожигатель жизни. В один из загулов ночью он вступился за приятеля, подрался с полицейскими, выбил табельное оружие у офицера... В итоге отец лишает героя всего и отправляет работать в отделение полиции - то самое, в котором служат ночные полицейские. Его, мажора, там не ждут. Его презирают. Но именно там он начнет становиться мужчиной, встретит свою любовь и найдет убийцу мамы."
        ),
        ListDetailedData(
            id = 12,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/6201401/791d5250-96e7-47ef-a5ea-a791c6e4fe14/300x450",
            headerText = "Пищеблок",
            infoText = "Пока вся страна следит за Олимпиадой-80, в пионерском лагере «Буревестник» на Волге происходят странные события. Дети загадочно исчезают по ночам, а потом возвращаются — но совсем не такими, как прежде. Увлеченные летней свободой и друг другом вожатые не замечают, как в их отрядах оживают страшные пионерские легенды, а руководство лагеря делает вид, что все в порядке. Разбираться в тайнах «Буревестника» придется мальчику Валерке и вожатому Игорю. Для начала им предстоит понять, остался ли в лагере хоть кто-то, кому можно доверять."
        ),
        ListDetailedData(
            id = 13,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/10853012/e65a4287-7631-46b2-b79d-323bed05cf8b/300x450",
            headerText = "Ивановы-Ивановы",
            infoText = "Две семьи Ивановых узнают, что 16 лет назад их детей перепутали в роддоме. Как быть, если любимый сын на самом деле не родной, а твою кровиночку воспитывают чужие люди? Ещё и в роскоши, которая тебе даже не снилась. И как он примет своих новых, но уж больно бедных родственников?"
        ),
        ListDetailedData(
            id = 14,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/ce84bf0e-d302-4c64-8404-942f2f0e84c2/300x450",
            headerText = "Чернобыль: Зона отчуждения",
            infoText = "Пятеро молодых людей прыгают в старую «Волгу» и отправляются на поиски вора, часом ранее укравшего из квартиры родителей главного героя восемь миллионов рублей. Грабитель — обычный московский айтишник, — вместо того чтобы залечь на дно, тут же записывает видеоотчет, в котором сообщает, что финальная точка его путешествия — Чернобыльская АЭС и город Припять."
        ),
        ListDetailedData(
            id = 15,
            imageUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/270df10e-2e72-4d8e-a49b-f84c751162a7/300x450",
            headerText = "Доктор Хаус",
            infoText = "Сериал рассказывает о команде врачей, которые должны правильно поставить диагноз пациенту и спасти его. Возглавляет команду доктор Грегори Хаус, который ходит с тростью после того, как его мышечный инфаркт в правой ноге слишком поздно правильно диагностировали. Как врач Хаус просто гений, но сам не отличается проникновенностью в общении с больными и с удовольствием избегает их, если только есть возможность. Он сам всё время проводит в борьбе с собственной болью, а трость в его руке только подчеркивает его жесткую, ядовитую манеру общения. Порой его поведение можно назвать почти бесчеловечным, и при этом он прекрасный врач, обладающий нетипичным умом и безупречным инстинктом, что снискало ему глубокое уважение..."
        )
    )

    fun getInfo(id: Int) : ListDetailedData? {
        for (i in 0 until listInfo.size) {
            if (listInfo.get(i).id == id) {
                return listInfo.get(i)
            }
        }
        return null
    }

}