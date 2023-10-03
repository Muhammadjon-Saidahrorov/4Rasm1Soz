package uz.gita.fourpiconewordmn.ui.game

import android.util.Log
import uz.gita.fourpiconewordmn.model.QuestionData

class GamePresenter constructor(private var view: GameContract.View):GameContract.Presenter {
    private var model: GameContract.Model = GameModel()
    private var typedAnswers: ArrayList<String?> = ArrayList(8)
    private var typedVariants: ArrayList<Boolean?> = ArrayList(14)

    override fun loadCurrentQuestion() {
        view.clearOldData()
        view.showQuestionImagesToView(model.questionData().imageQuestions)
        view.showVariantsToView(model.questionData().variant)
        view.setVisibilityToAnswer(model.questionData().answer.length)
        view.countCoin()
        initTypedArrays()
    }

    override fun answerBtnClick(clickedPosition: Int) {
        var question: QuestionData = model.questionData()
        var variant = question.variant
        var typedLetter: String? = typedAnswers[clickedPosition] ?: return

        for (i in 0 until 14) {
            if (variant[i].toString() == typedLetter && typedVariants[i]!!) {
                view.setEnabledVariantByPos(i, true)
                typedVariants[i] = false
                typedAnswers[clickedPosition] = null
                view.setTextToAnswer(clickedPosition, "")
                view.setDefaultColorToAnswers()
                return
            }
        }
    }

    override fun variantBtnClick(clickedPosition: Int) {
        var positionAnswer: Int = typedAnswers.indexOf(null)
        if (positionAnswer == -1) return

        var question = model.questionData()

        var variant = question.variant
        var letter = variant[clickedPosition].toString()
        view.setTextToAnswer(positionAnswer, letter)
        typedAnswers[positionAnswer] = letter
        view.setEnabledVariantByPos(clickedPosition, false)
        typedVariants[clickedPosition] = true
        isWin()
    }

    override fun finishActivity() {
        view.closeActivity()
    }

    override fun loadNextQuestion() {
        loadCurrentQuestion()
    }

    override fun showAnswerClick() {
        view.showAnswerDialog()
    }

    override fun helpAnswer() {
        val question: QuestionData = model.questionData()
        val answer = question.answer
        for (i in answer.indices) {
            var ansLetter: String = answer[i].toString()
            var pos: Int = getPosVariantByLetter(ansLetter)
            Log.d("TTT","helpAnswer: ${typedAnswers[i]}")
            if (typedAnswers[i] == null){
                typedAnswers[i] = ansLetter
                view.setTextToAnswer(i,ansLetter)
                saveCoin(getCoin()-10)
                view.countCoin()
                typedVariants[pos] = true
                view.setEnabledVariantByPos(pos,false)
                view.setCorrectColor(i)
                isWin()
                return
            }
        }
    }

    override fun backBtn() {
        view.closeActivity()
    }

    override fun clear() {
        for (i in typedAnswers.indices){
            typedAnswers[i] = null
        }
        for (i in typedVariants.indices){
            typedVariants[i] = false
        }
    }

    private fun getPosVariantByLetter(letter: String): Int {
        val question: QuestionData = model.questionData()
        val variant = question.variant

        for (i in variant.indices) {
            if ((variant[i].toString() == letter) && !(typedVariants[i]!!))
                return i
        }
        return -1
    }

    private fun isWin() {
        val questionData = model.questionData()
        val answer = questionData.answer
        val sb = StringBuilder()
        for (i in 0 until typedAnswers.size) {
            sb.append(typedAnswers[i])
        }
        val userAnswer = sb.toString()
        if (userAnswer.length != answer.length) return

        if (userAnswer == answer) {
            if (model.currentQuestionPos() + 1 == 35) {
                saveQuestionPos(0)
                view.setCorrectColorToAnswers()
                view.gameOver()
            } else {
                model.saveCoin(model.getCoin() + 6)
                saveQuestionPos(model.currentQuestionPos() + 1)
                view.setCorrectColorToAnswers()
                view.showDialog()
            }
        } else {
            view.setWrongColorToAnswers()
            view.wrongAnswerAnimation()
        }
    }

    private fun saveQuestionPos(questionPos: Int) {
        model.saveCurrentQuestionPos(questionPos)
    }

    private fun initTypedArrays() {
        var answerSize = model.questionData().answer.length
        typedAnswers = ArrayList(answerSize)

        for (i in 0 until answerSize) {
            typedAnswers.add(null)
        }

        for (i in 0 until 14) {
            typedVariants.add(false)
        }
    }

    override fun getCoin(): Int = model.getCoin()
    override fun saveCoin(count: Int) {
        model.saveCoin(count)
    }
}