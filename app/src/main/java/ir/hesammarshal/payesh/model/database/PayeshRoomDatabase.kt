package ir.hesammarshal.payesh.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.hesammarshal.payesh.model.entities.PayeshHeart

@Database(entities = [PayeshHeart::class], version = 1)
abstract class PayeshRoomDatabase: RoomDatabase() {

    abstract fun payeshDao() : PayeshDao

    companion object{
        @Volatile
        private var INSTANCE: PayeshRoomDatabase? = null
        fun getDatabase(context: Context): PayeshRoomDatabase {

            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PayeshRoomDatabase::class.java,
                    "fav_dish_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}