package kg.geektech.taskmanager

import android.app.Application
import androidx.room.Room
import kg.geektech.taskmanager.data.local.AppDataBase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

 companion object{
     lateinit var db:AppDataBase
 }
}