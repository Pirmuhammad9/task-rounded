package uz.gita.taskrounded.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.gita.taskrounded.data.local.room.entity.DataEntity

@Dao
interface DataDao {

    @Query("SELECT * from DataEntity where current = :page limit 20")
    suspend fun getData(page: Int): List<DataEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(dataEntity: DataEntity)

}