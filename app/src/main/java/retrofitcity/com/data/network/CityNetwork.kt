package retrofitcity.com.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofitcity.com.data.model.City

interface CityNetwork {

    @GET("search?")
    fun getCity(@Query("query")searchString: String): Call<List<City>>
}