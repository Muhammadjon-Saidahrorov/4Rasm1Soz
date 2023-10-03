package uz.gita.fourpiconewordmn.ui.enter

class EnterPresenter constructor(private val mainView:EnterContract.View):EnterContract.Presenter {
    private val maiModel: EnterContract.Model = EnterModel()

    override fun loadCurrentQuestion() {
        mainView.setQuestionPos(maiModel.getCurrentQuestionPos())
        mainView.setImagesToView(maiModel.getCurrentQuestionImages())
    }

    override fun startGameActivity() {
        mainView.goToGameActivity()
    }

    override fun startInfoActivity() {
        mainView.goToInfoActivity()
    }
}