package uz.gita.fourpiconewordmn.ui.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import uz.gita.fourpiconewordmn.R

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val btnBack = findViewById<AppCompatImageView>(R.id.iconBackIdInfo)

        btnBack.setOnClickListener{
            finish()
        }
    }
}