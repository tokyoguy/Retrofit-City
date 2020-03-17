package retrofitcity.com.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofitcity.com.data.model.City
import retrofitcity.com.data.network.CityNetwork
import retrofitcity.com.utils.CITY_URL

class CityActivityRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val cityList = MutableLiveData<List<City>>()

    fun changeState() {
        if (showProgress.value != null && showProgress.value!!) {
            showProgress.value = true
        } else {
            showProgress.value = false
        }
    }

    fun searchCity(searchString: String) {
        showProgress.value = true

        val retrofit =
            Retrofit.Builder()
                .baseUrl(CITY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(CityNetwork::class.java)

        service.getCity(searchString).enqueue(object: Callback<List<City>> {
            override fun onFailure(call: Call<List<City>>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application, "Ошибка сети..", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {
                cityList.value = response.body()
                showProgress.value = false
            }
        })
    }
}