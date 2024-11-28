package ru.itis.hw3_viewpager.repository

import ru.itis.hw3_viewpager.R
import ru.itis.hw3_viewpager.model.ItemQuestionModel
import ru.itis.hw3_viewpager.model.QuestionWithAnswers

class ScreensContentRepo {


    fun getInfo (position: Int) : QuestionWithAnswers {
        when (position) {
            0 -> {
                return QuestionWithAnswers(
                    id = 1,
                    question = "Как ты себя обычно чувствуешь по утрам?" ,
                    answers = listOf(
                        ItemQuestionModel(0, "Энергично"),
                        ItemQuestionModel(1, "Нормально"),
                        ItemQuestionModel(2,  "Сонно"),
                        ItemQuestionModel(3, "Уставший")
                    )
                )
            }

            1 -> {
                return QuestionWithAnswers(
                    id = 2,
                    question = "Как ты реагируешь на стресс?",
                    answers = listOf(
                        ItemQuestionModel(0, "Спокойно"),
                        ItemQuestionModel(1, "Паника"),
                        ItemQuestionModel(2, "Тревожность"),
                        ItemQuestionModel(3, "Напряжение"),
                        ItemQuestionModel(4, "Безразличие")
                    )
                )
            }

            2 -> {
                return QuestionWithAnswers(
                    id = 3,
                    question = "Как ты проводишь выходные?",
                    answers = listOf(
                        ItemQuestionModel(0, "С друзьями"),
                        ItemQuestionModel(1, "Дома"),
                        ItemQuestionModel(2, "Сплю"),
                        ItemQuestionModel(3, "Занимаюсь делами")
                    )
                )
            }

            3 -> {
                return QuestionWithAnswers(
                    id = 4,
                    question = "Как справляешься с трудными задачами?",
                    answers = listOf(
                        ItemQuestionModel(0, "Легко"),
                        ItemQuestionModel(1, "Проблемы"),
                        ItemQuestionModel(2, "Избегаю"),
                        ItemQuestionModel(3, "Трудно")
                    )
                )
            }

            4 -> {
                return QuestionWithAnswers(
                    id = 5,
                    question = "Чем ты занимаешься вечером?",
                    answers = listOf(
                        ItemQuestionModel(0, "Спорт"),
                        ItemQuestionModel(1, "Отдых"),
                        ItemQuestionModel(2, "Работа"),
                        ItemQuestionModel(3, "Учёба"),
                        ItemQuestionModel(4, "Смотрю ТВ"),
                    )
                )
            }

            5 -> {
                return QuestionWithAnswers(
                    id = 6,
                    question = "Как ты себя чувствуешь после тренировки?",
                    answers = listOf(
                        ItemQuestionModel(0, "Энергичен"),
                        ItemQuestionModel(1, "Устал"),
                        ItemQuestionModel(2, "Выжат"),
                        ItemQuestionModel(3, "Не тренируюсь")
                    )
                )
            }

            6 -> {
                return QuestionWithAnswers(
                    id = 7,
                    question = " Как решаешь проблемы?",
                    answers = listOf(
                        ItemQuestionModel(0, "Активно"),
                        ItemQuestionModel(1, "Обдумываю"),
                        ItemQuestionModel(2, "Избегаю"),
                        ItemQuestionModel(3, "Паника")
                    )
                )
            }

            7 -> {
                return QuestionWithAnswers(
                    id = 8,
                    question = "Как ты обычно начинаешь свой день?",
                    answers = listOf(
                        ItemQuestionModel(0, "Завтрак"),
                        ItemQuestionModel(1, "Утренний спорт"),
                        ItemQuestionModel(2, "Работа"),
                        ItemQuestionModel(3, "Сон")
                    )
                )
            }

            8 -> {
                return QuestionWithAnswers(
                    id = 9,
                    question = "Что для тебя важно в жизни?",
                    answers = listOf(
                        ItemQuestionModel(0, "Здоровье"),
                        ItemQuestionModel(1, "Карьера"),
                        ItemQuestionModel(2, "Семья"),
                        ItemQuestionModel(3, "Деньги"),
                        ItemQuestionModel(4, "Любовь")
                    )
                )
            }

            else -> {
                return QuestionWithAnswers(
                    id = 10,
                    question = "Как ты относишься к переменам?",
                    answers = listOf(
                        ItemQuestionModel(0, "Легко"),
                        ItemQuestionModel(1, "Привыкаю"),
                        ItemQuestionModel(2, "Боюсь"),
                        ItemQuestionModel(3, "Пугают")
                    )
                )
            }
        }

    }
}