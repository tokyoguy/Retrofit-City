package retrofitcity.com.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_city.*
import retrofitcity.com.R
import retrofitcity.com.ui.viewmodel.CityActivityViewModel

class CityActivity: AppCompatActivity() {

    private lateinit var viewModel: CityActivityViewModel
    private lateinit var cityAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        viewModel = ViewModelProvider(this).get(CityActivityViewModel::class.java)

        cityAdapter = CityAdapter()
        city_recyclerview.adapter = cityAdapter

        icon_search.setOnClickListener {
            if (edittext_search.text!!.isNotEmpty())
                viewModel.searchCity(edittext_search.text.toString())
            viewModel.changeState()
        }

        viewModel.showProgress.observe(this, Observer {
            if(it) {
                progress_bar.visibility = View.VISIBLE
            } else {
                progress_bar.visibility = View.GONE
            }
        })

        viewModel.cityList.observe(this, Observer {
            cityAdapter.setLocationList(it)
        })
    }
}