package ir.hesammarshal.payesh.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ir.hesammarshal.payesh.model.database.PayeshRepository
import ir.hesammarshal.payesh.model.entities.PayeshHeart
import kotlinx.coroutines.launch

class PayeshViewModel (private val repository: PayeshRepository) : ViewModel() {
    fun insert (item : PayeshHeart) = viewModelScope.launch {
        repository.insertHeartData(item)
    }
}
class  PayeshViewModelFactory(private val repository: PayeshRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PayeshViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PayeshViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}