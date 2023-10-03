package uz.gita.fourpiconewordmn.ui.enter

import uz.gita.fourpiconewordmn.repository.AppRepository

class EnterModel: EnterContract.Model {
    private val repository: AppRepository = AppRepository.getInstance()

    override fun getCurrentQuestionPos() =
        repository.getCurrentQuestionPos()


    override fun getCurrentQuestionImages(): List<Int> {
        return repository.getCurrentQuestionData().imageQuestions
    }
}