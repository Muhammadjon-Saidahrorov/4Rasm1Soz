package uz.gita.fourpiconewordmn.model

data class QuestionData(
    val imageQuestions: MutableList<Int>,
    val answer: String,
    val variant: String
)