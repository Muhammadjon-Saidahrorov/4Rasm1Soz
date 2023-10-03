package uz.gita.fourpiconewordmn.ui.game

import uz.gita.fourpiconewordmn.model.QuestionData
import uz.gita.fourpiconewordmn.repository.AppRepository

class GameModel : GameContract.Model {
    private var appRepository: AppRepository? = null

    init {
        appRepository = AppRepository.getInstance()
    }

    override fun questionData(): QuestionData =
        appRepository!!.getCurrentQuestionData()

    override fun saveCurrentQuestionPos(pos: Int) =
        appRepository!!.saveCurrentQuestionByPos(pos)

    override fun currentQuestionPos(): Int =
        appRepository!!.getCurrentQuestionPos()

    override fun saveCoin(count: Int) =
        appRepository!!.saveCoin(count)


    override fun getCoin(): Int =
        appRepository!!.getCoin()

}