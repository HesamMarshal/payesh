package ir.hesammarshal.payesh.application

import android.app.Application
import ir.hesammarshal.payesh.model.database.PayeshRepository
import ir.hesammarshal.payesh.model.database.PayeshRoomDatabase

class PayeshApplication : Application(){
    private val database by lazy {PayeshRoomDatabase.getDatabase(this@PayeshApplication)}
    val repository by lazy {PayeshRepository(database.payeshDao())}

}