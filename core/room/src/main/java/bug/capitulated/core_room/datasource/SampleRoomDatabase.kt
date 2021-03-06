package bug.capitulated.core_room.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import bug.capitulated.core_room.datasource.dao.SampleDao
import bug.capitulated.core_room.datasource.entity.SampleEntity

@Database(
    version = 1,
    entities = [SampleEntity::class]
)
internal abstract class SampleRoomDatabase : RoomDatabase() {
    
    abstract fun getTitleDao(): SampleDao
    
    companion object {
        
        @Synchronized
        fun createDatabase(
            appContext: Context,
            databaseName: String = "database"
        ): SampleRoomDatabase {
            return Room.databaseBuilder(appContext, SampleRoomDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration() // Attention
                .build()
        }
        
    }
    
}