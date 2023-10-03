package uz.gita.fourpiconewordmn.app

import android.app.Application
import uz.gita.fourpiconewordmn.LocalStorage
import uz.gita.fourpiconewordmn.repository.AppRepository

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
        AppRepository.init()
    }

}