package uz.gita.fourpiconewordmn.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import uz.gita.fourpiconewordmn.R
import uz.gita.fourpiconewordmn.utils.Constants.*

class GameActivity : AppCompatActivity(), GameContract.View {
    private lateinit var presenter: GameContract.Presenter
    private lateinit var questionsImg: MutableList<ImageView>
    private lateinit var variants: MutableList<TextView>
    private lateinit var answers: MutableList<TextView>
    private lateinit var showAnswer: AppCompatImageView
    private lateinit var backBtn: AppCompatImageView
    private lateinit var countCoin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        presenter = GamePresenter(this)
        load()
        presenter.loadCurrentQuestion()
    }

    private fun load() {
        questionsImg = ArrayList(MAX_IMAGES.value)

        questionsImg.add(findViewById(R.id.image1))
        questionsImg.add(findViewById(R.id.image2))
        questionsImg.add(findViewById(R.id.image3))
        questionsImg.add(findViewById(R.id.image4))

        answers = ArrayList(MAX_ANSWERS.value)
        val parentViewGroupOfAnswers = findViewById<LinearLayout>(R.id.answers)

        for (i in 0 until MAX_ANSWERS.value) {
            val btn: TextView = parentViewGroupOfAnswers.getChildAt(i) as TextView
            btn.tag = i
            answers.add(btn)
        }

        variants = ArrayList(MAX_VARIANTS.value)
        val parentViewGroupOfVariants = findViewById<RelativeLayout>(R.id.variants)

        for (i in 0 until MAX_VARIANTS.value) {
            val btn = parentViewGroupOfVariants.getChildAt(i)
            btn.tag = i
            variants.add(btn as TextView)
        }

        showAnswer = findViewById(R.id.iconAnswerId)
        backBtn = findViewById(R.id.iconBackId)

        countCoin = findViewById(R.id.coinId)
        addClickActions()

    }

    override fun countCoin() {
        countCoin.text = presenter.getCoin().toString()
    }


    override fun showQuestionImagesToView(questionImages: List<Int>) {
        for (i in 0 until MAX_IMAGES.value) {
            questionsImg[i].setImageResource(questionImages[i])
        }
    }

    override fun showVariantsToView(variant: String) {
        for (i in 0 until MAX_VARIANTS.value) {
            variants[i].text = variant[i].toString()
        }
    }

    override fun setVisibilityToAnswer(answerLength: Int) {
        for (i in 0 until answerLength) {
            answers[i].visibility = View.VISIBLE
        }

        for (i in answerLength until MAX_ANSWERS.value) {
            answers[i].visibility = View.GONE
        }
    }

    override fun clearOldData() {
        for (i in 0 until MAX_ANSWERS.value) {
            answers[i].text = ""
        }

        for (i in 0 until MAX_VARIANTS.value) {
            variants[i].isEnabled = true
        }

        presenter.clear()
    }

    override fun closeActivity() {
        finish()
    }

    override fun showDialog() {
        val view: View = LayoutInflater.from(this).inflate(R.layout.win_dialog, null)
        val dialogBuilder: AlertDialog = AlertDialog.Builder(this)
            .setCancelable(false)
            .setView(view)
            .create()

        dialogBuilder.show()
        dialogBuilder.window?.setBackgroundDrawable(null)

        view.findViewById<AppCompatButton>(R.id.nextBtn).setOnClickListener{
            presenter.loadNextQuestion()
            setDefaultColorToAnswers()
            dialogBuilder.dismiss()
        }
    }

    override fun showAnswerDialog() {

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            .setCancelable(false)
            .setTitle("Yordam!")
            .setMessage("Agar foydalanmoqchi bo'lsangiz 10 tanga yo'qotasiz!?")
            .setPositiveButton("Ha") { dialogInterface, i ->
                dialogInterface.cancel()
                if (presenter.getCoin() >= 10) {
                    presenter.helpAnswer()
                } else {
                    Toast.makeText(this, "Tanga yetarli emas!", Toast.LENGTH_SHORT).show()
                }
                this.countCoin()

            }
            .setNegativeButton("Yo'q") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()

    }


    override fun setTextToAnswer(pos: Int, letter: String) {
        answers[pos].text = letter
    }

    override fun setEnabledVariantByPos(pos: Int, state: Boolean) {
        variants[pos].isEnabled = state
    }

    override fun wrongAnswerAnimation() {
        YoYo.with(Techniques.Shake).duration(600).playOn(findViewById(R.id.answers))
    }

    override fun setWrongColorToAnswers() {
        for (i in 0 until MAX_ANSWERS.value) {
            answers[i].setTextColor(resources.getColor(R.color.red));
        }
    }

    override fun setCorrectColorToAnswers() {
        for (i in 0 until MAX_ANSWERS.value) {
            answers[i].setTextColor(resources.getColor(R.color.green));
        }
    }

    override fun setCorrectColor(pos: Int) {
        answers[pos].setTextColor(resources.getColor(R.color.green));
    }

    override fun setDefaultColorToAnswers() {
        for (i in 0 until MAX_ANSWERS.value) {
            answers[i].setTextColor(resources.getColor(R.color.white));
        }
    }

    override fun gameOver() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            .setCancelable(false)
            .setTitle("Tabriklaymiz!")
            .setMessage("O'yin tugadi!")
            .setPositiveButton("Ok") { _, _ ->
                presenter.finishActivity()
            }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        presenter.finishActivity()
    }

    private fun addClickActions() {
        for (i in 0 until MAX_ANSWERS.value) {
            answers[i].setOnClickListener {
                presenter.answerBtnClick(it.tag as Int)
            }
        }

        for (i in 0 until MAX_VARIANTS.value) {
            variants[i].setOnClickListener {
                presenter.variantBtnClick(it.tag as Int)
            }
        }

        showAnswer.setOnClickListener {
            presenter.showAnswerClick()
        }

        backBtn.setOnClickListener {
            presenter.backBtn()
        }

    }
}