package uz.gita.fourpiconewordmn.repository

import uz.gita.fourpiconewordmn.LocalStorage
import uz.gita.fourpiconewordmn.R
import uz.gita.fourpiconewordmn.model.QuestionData
import java.util.*
import kotlin.collections.ArrayList

class AppRepository private constructor() {
    private val questionData: MutableList<QuestionData> = ArrayList()
    private var localStorage: LocalStorage = LocalStorage.getInstance()

    companion object {
        private lateinit var appRepository: AppRepository

        fun init() {
            if (!this::appRepository.isInitialized) appRepository = AppRepository()
        }

        fun getInstance(): AppRepository {
            return appRepository
        }
    }


    init {
        initQuestions()
    }



    fun saveCurrentQuestionByPos(pos: Int) {
        localStorage.saveQuestionPos(pos)
    }

    fun getCurrentQuestionPos(): Int {
        return localStorage.getQuestionPos()
    }

    fun getCurrentQuestionData(): QuestionData =
        questionData[getCurrentQuestionPos()]

    fun saveCoin(count: Int) {
        localStorage.saveCoin(count)
    }

    fun getCoin(): Int {
        return localStorage.getCoin()
    }

    private fun initQuestions() {

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_6_1_book,
                    R.drawable.classroom_6_2_book,
                    R.drawable.classroom_6_3_book,
                    R.drawable.classroom_6_4_book
                ), "KITOB", generateVariant("KITOB")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic2_1,
                    R.drawable.pic2_2,
                    R.drawable.pic2_3,
                    R.drawable.pic2_4
                ), "OLMA", generateVariant("OLMA")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic1_1,
                    R.drawable.pic1_2,
                    R.drawable.pic1_3,
                    R.drawable.pic1_4
                ), "O'QISH", generateVariant("O'QISH")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.color_2_1_white,
                    R.drawable.color_2_2_white,
                    R.drawable.color_2_3_white,
                    R.drawable.color_2_4_white
                ), "OQ", generateVariant("OQ")
            )
        )


        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic3_1,
                    R.drawable.pic3_2,
                    R.drawable.pic3_3,
                    R.drawable.pic3_4
                ), "SUZISH", generateVariant("SUZISH")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic4_1,
                    R.drawable.pic4_2,
                    R.drawable.pic4_3,
                    R.drawable.pic4_4,
                ), "ISH", generateVariant("ISH")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic5_1,
                    R.drawable.pic5_2,
                    R.drawable.pic5_3,
                    R.drawable.pic5_4
                ), "TELEFON", generateVariant("TELEFON")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic6_1,
                    R.drawable.pic6_2,
                    R.drawable.pic6_3,
                    R.drawable.pic6_4
                ), "FUTBOL", generateVariant("FUTBOL")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.color_3_1_green,
                    R.drawable.color_3_2_green,
                    R.drawable.color_3_3_green,
                    R.drawable.color_3_4_green
                ), "YASHIL", generateVariant("YASHIL")
            )
        )


        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_9_1_scissor,
                    R.drawable.classroom_9_2_scissor,
                    R.drawable.classroom_9_3_scissor,
                    R.drawable.classroom_9_4_scissor
                ), "QAYCHI", generateVariant("QAYCHI")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_10_1_notebook,
                    R.drawable.classroom_10_2_notebook,
                    R.drawable.classroom_10_3_notebook,
                    R.drawable.classroom_10_4_notebook
                ), "DAFTAR", generateVariant("DAFTAR")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic7_1,
                    R.drawable.pic7_2,
                    R.drawable.pic7_3,
                    R.drawable.pic7_4
                ), "FASL", generateVariant("FASL")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.color_9_1_grey,
                    R.drawable.color_9_2_grey,
                    R.drawable.color_9_3_grey,
                    R.drawable.color_9_4_grey
                ), "KULRANG", generateVariant("KULRANG")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic8_1,
                    R.drawable.pic8_2,
                    R.drawable.pic8_3,
                    R.drawable.pic8_4
                ), "CHIROQ", generateVariant("CHIROQ")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic9_1,
                    R.drawable.pic9_2,
                    R.drawable.pic9_3,
                    R.drawable.pic9_4
                ), "JAHL", generateVariant("JAHL")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.color_4_1_blue,
                    R.drawable.color_4_2_blue,
                    R.drawable.color_4_3_blue,
                    R.drawable.color_4_4_blue
                ), "KO'K", generateVariant("KO'K")
            )
        )


        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic10_1,
                    R.drawable.pic10_2,
                    R.drawable.pic10_3,
                    R.drawable.pic10_4
                ), "AMERIKA", generateVariant("AMERIKA")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_5_1_desk,
                    R.drawable.classroom_5_2_desk,
                    R.drawable.classroom_5_3_desk,
                    R.drawable.classroom_5_4_desk
                ), "PARTA", generateVariant("PARTA")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic12_1,
                    R.drawable.pic12_2,
                    R.drawable.pic12_3,
                    R.drawable.pic12_4
                ), "O'YIN", generateVariant("O'YIN")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic13_1,
                    R.drawable.pic13_2,
                    R.drawable.pic13_3,
                    R.drawable.pic13_4
                ), "HOVLI", generateVariant("HOVLI")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic14_1,
                    R.drawable.pic14_2,
                    R.drawable.pic14_3,
                    R.drawable.pic14_4
                ), "XAT", generateVariant("XAT")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic15_1,
                    R.drawable.pic15_2,
                    R.drawable.pic15_3,
                    R.drawable.pic15_4
                ), "TABASSUM", generateVariant("TABASSUM")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic16_1,
                    R.drawable.pic16_2,
                    R.drawable.pic16_3,
                    R.drawable.pic16_4
                ), "SAMOLYOT", generateVariant("SAMOLYOT")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_3_1_chair,
                    R.drawable.classroom_3_2_chair,
                    R.drawable.classroom_3_3_chair,
                    R.drawable.classroom_3_4_chair
                ), "STUL", generateVariant("STUL")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.color_1_1_black,
                    R.drawable.color_1_2_black,
                    R.drawable.color_1_3_black,
                    R.drawable.color_1_4_black
                ), "QORA", generateVariant("QORA")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_4_1_board,
                    R.drawable.classroom_4_2_board,
                    R.drawable.classroom_4_3_board,
                    R.drawable.classroom_4_4_board
                ), "DOSKA", generateVariant("DOSKA")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic17_1,
                    R.drawable.pic17_2,
                    R.drawable.pic17_3,
                    R.drawable.pic17_4
                ), "TOVUSH", generateVariant("TOVUSH")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_1_1_pencil,
                    R.drawable.classroom_1_2_pencil,
                    R.drawable.classroom_1_3_pencil,
                    R.drawable.classroom_1_4_pencil
                ), "QALAM", generateVariant("QALAM")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.color_5_1_yellow,
                    R.drawable.color_5_2_yellow,
                    R.drawable.color_5_3_yellow,
                    R.drawable.color_5_4_yellow
                ), "SARIQ", generateVariant("SARIQ")
            )
        )


        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic18_1,
                    R.drawable.pic18_2,
                    R.drawable.pic18_3,
                    R.drawable.pic18_4
                ), "MASHINA", generateVariant("MASHINA")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_8_1_glue,
                    R.drawable.classroom_8_2_glue,
                    R.drawable.classroom_8_3_glue,
                    R.drawable.classroom_8_4_glue
                ), "YELIM", generateVariant("YELIM")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic19_1,
                    R.drawable.pic19_2,
                    R.drawable.pic19_3,
                    R.drawable.pic19_4
                ), "OY", generateVariant("OY")
            )
        )
        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.color_6_1_pink,
                    R.drawable.color_6_2_pink,
                    R.drawable.color_6_3_pink,
                    R.drawable.color_6_4_pink
                ), "PUSHTI", generateVariant("PUSHTI")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic20_1,
                    R.drawable.pic20_2,
                    R.drawable.pic20_3,
                    R.drawable.pic20_4
                ), "O'QUVCHI", generateVariant("O'QUVCHI")
            )
        )

        questionData.add(
            QuestionData(
                mutableListOf(
                    R.drawable.classroom_2_1_bag,
                    R.drawable.classroom_2_2_bag,
                    R.drawable.classroom_2_3_bag,
                    R.drawable.classroom_2_4_bag
                ), "SUMKA", generateVariant("SUMKA")
            )
        )

    }

    private fun generateVariant(answer: String): String {
        val variant: MutableList<String> = ArrayList(14)
        val letters = listOf(
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z", "'"
        )
        for (i in answer) {
            variant.add(i.toString())
        }

        val random = Random()
        for (i in answer.length until 14) {
            variant.add(letters[random.nextInt(27)])
        }
        variant.shuffle()
        val sb = StringBuilder()
        for (i in variant.indices) {
            sb.append(variant[i])
        }

        return sb.toString()
    }

}