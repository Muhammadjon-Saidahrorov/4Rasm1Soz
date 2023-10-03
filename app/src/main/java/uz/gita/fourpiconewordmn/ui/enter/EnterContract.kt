package uz.gita.fourpiconewordmn.ui.enter

interface EnterContract {
    interface Model {
        fun getCurrentQuestionPos():Int
        fun getCurrentQuestionImages():List<Int>
    }

    interface Presenter {
        fun loadCurrentQuestion()
        fun startGameActivity()
        fun startInfoActivity()
    }

    interface View {
        fun setImagesToView(images:List<Int>)
        fun setQuestionPos(pos:Int)
        fun goToGameActivity()
        fun goToInfoActivity()
    }
}