package ir.hesammarshal.payesh.model.database

import androidx.annotation.WorkerThread
import ir.hesammarshal.payesh.model.entities.PayeshHeart

class PayeshRepository (private val payeshDao: PayeshDao) {

    @WorkerThread
    suspend fun insertHeartData (payeshHeart: PayeshHeart){
        payeshDao.insertHeartDetails(payeshHeart)
    }
}