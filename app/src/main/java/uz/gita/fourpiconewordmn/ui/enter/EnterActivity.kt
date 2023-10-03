package uz.gita.fourpiconewordmn.ui.enter

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import uz.gita.fourpiconewordmn.R
import uz.gita.fourpiconewordmn.ui.game.GameActivity
import uz.gita.fourpiconewordmn.ui.info.InfoActivity
import uz.gita.fourpiconewordmn.utils.Constants

class EnterActivity : AppCompatActivity(), EnterContract.View {
    private lateinit var playButton: AppCompatButton
    private lateinit var aboutButton: AppCompatButton
    private lateinit var questionsImg: MutableList<ImageView>
    private lateinit var currentQuestionPos: AppCompatTextView
    private lateinit var presenter: EnterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        presenter = EnterPresenter(this)
        findViews()
    }

    override fun onResume() {
        super.onResume()
        presenter.loadCurrentQuestion()
    }

    private fun findViews() {
        questionsImg = ArrayList()

        questionsImg.add(findViewById<ImageView>(R.id.image1))
        questionsImg.add(findViewById<ImageView>(R.id.image2))
        questionsImg.add(findViewById<ImageView>(R.id.image3))
        questionsImg.add(findViewById<ImageView>(R.id.image4))

        currentQuestionPos = findViewById<AppCompatTextView>(R.id.textQuestionPos)

        playButton = findViewById(R.id.buttonPlay)
        aboutButton = findViewById(R.id.buttonAbout)

        clickEvents()
    }

    private fun clickEvents() {
        playButton.setOnClickListener{
            presenter.startGameActivity()
        }
        aboutButton.setOnClickListener{
            presenter.startInfoActivity()
        }

    }

    override fun setImagesToView(images: List<Int>) {
        for (i in 0 until Constants.MAX_IMAGES.value) {
            questionsImg[i].setImageResource(images[i])
        }
    }

    @SuppressLint("SetTextI18n")
    override fun setQuestionPos(pos: Int) {
        currentQuestionPos.text = (pos + 1).toString()
    }

    override fun goToGameActivity() {
        startActivity(Intent(this, GameActivity::class.java))
    }

    override fun goToInfoActivity() {
        startActivity(Intent(this,InfoActivity::class.java))
    }
}