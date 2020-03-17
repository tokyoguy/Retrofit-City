package retrofitcity.com.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import retrofitcity.com.data.model.City
import retrofitcity.com.repository.CityActivityRepository

class CityActivityViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CityActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val cityList: LiveData<List<City>>

    init {
        this.showProgress = repository.showProgress
        this.cityList = repository.cityList
    }

    fun changeState() {
        repository.changeState()
    }

    fun searchCity(searchString: String) {
        repository.searchCity(searchString)
    }
}