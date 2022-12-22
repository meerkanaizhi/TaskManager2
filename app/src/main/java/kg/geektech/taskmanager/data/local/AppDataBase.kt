package kg.geektech.taskmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.geektech.taskmanager.model.Task

@Database(entities = [Task::class], version = 1)

abstract class AppDataBase:RoomDatabase() {
    abstract fun dao(): TaskDao
}