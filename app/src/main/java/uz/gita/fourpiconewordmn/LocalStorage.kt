package uz.gita.fourpiconewordmn

import android.content.Context
import android.content.SharedPreferences

class LocalStorage private constructor(context: Context) {
    private var preferences: SharedPreferences
    private var editor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences("PIC4", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }


    companion object {
        private lateinit var localStorage: LocalStorage

        fun getInstance(): LocalStorage {
            return localStorage
        }

        fun init(context: Context) {
            if (!this::localStorage.isInitialized) localStorage = LocalStorage(context)
        }

    }

    fun saveQuestionPos(pos: Int) {
        preferences.edit().putInt("QUESTION_POS", pos).apply()
    }

    fun getQuestionPos(): Int {
        return preferences.getInt("QUESTION_POS", 0)
    }

    fun saveCoin(count: Int){
        preferences.edit().putInt("COIN",count).apply()
    }

    fun getCoin(): Int{
        return preferences.getInt("COIN",60)
    }
}