package uz.gita.fourpiconewordmn.ui.game

import uz.gita.fourpiconewordmn.model.QuestionData

interface GameContract {
    interface Model {
        fun questionData(): QuestionData
        fun saveCurrentQuestionPos(pos: Int)
        fun currentQuestionPos(): Int
        fun saveCoin(count: Int)
        fun getCoin(): Int
    }

    interface Presenter {
        fun getCoin(): Int
        fun saveCoin(count: Int)
        fun loadCurrentQuestion()
        fun answerBtnClick(clickedPosition: Int)
        fun variantBtnClick(clickedPosition: Int)
        fun finishActivity()
        fun loadNextQuestion()
        fun showAnswerClick()
        fun helpAnswer()
        fun backBtn()
        fun clear()
    }

    interface View {
        fun countCoin()
        fun showQuestionImagesToView(questionImages: List<Int>)
        fun showVariantsToView(variant: String)
        fun setVisibilityToAnswer(answerLength: Int)
        fun clearOldData()
        fun closeActivity()
        fun showDialog()
        fun showAnswerDialog()
        fun setTextToAnswer(pos: Int, letter: String)
        fun setEnabledVariantByPos(pos: Int, state: Boolean)
        fun wrongAnswerAnimation()
        fun setWrongColorToAnswers()
        fun setCorrectColorToAnswers()
        fun setCorrectColor(pos: Int)
        fun setDefaultColorToAnswers()
        fun gameOver()
    }
}