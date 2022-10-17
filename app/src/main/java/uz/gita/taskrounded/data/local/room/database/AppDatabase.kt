package uz.gita.taskrounded.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.taskrounded.data.local.room.dao.DataDao
import uz.gita.taskrounded.data.local.room.entity.DataEntity

@Database(entities = [DataEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getDao():DataDao

}