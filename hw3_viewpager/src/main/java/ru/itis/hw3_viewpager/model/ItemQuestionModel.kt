package ru.itis.hw3_viewpager.model

import ru.itis.hw3_viewpager.R

data class ItemQuestionModel(
    val id: Int,
    val answer: String,
    var backgroundTint: Int = R.color.white,
    var isAnswerd: Boolean = false,
    var viewIsAnswer: Boolean = false,
    var image: Int = R.drawable.ic_is_not_answer
)
