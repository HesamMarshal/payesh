package ir.hesammarshal.payesh.model.database

import androidx.room.Dao
import androidx.room.Insert
import ir.hesammarshal.payesh.model.entities.PayeshHeart

@Dao
interface PayeshDao {

    @Insert
    suspend fun insertHeartDetails(payeshHeart: PayeshHeart)
}