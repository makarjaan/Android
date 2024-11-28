package ru.itis.hw3_viewpager.model

data class QuestionWithAnswers(
    var id : Int,
    var question: String? = null,
    var answers: List<ItemQuestionModel>? = null
)
