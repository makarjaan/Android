package ru.itis.apphomework2.model

open class ListData (
    open val id : Int
)

class ButtonData(
    override val id: Int
) : ListData(id)

class ListRecycleMainData(
    override val id: Int,
    val imageUrl: String,
    val description: String
) : ListData(id)


