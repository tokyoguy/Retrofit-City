package retrofitcity.com.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city.view.*
import retrofitcity.com.R
import retrofitcity.com.data.model.City

class CityAdapter(): RecyclerView.Adapter<CityAdapter.SearchViewHolder>() {
    class SearchViewHolder(view: View): RecyclerView.ViewHolder(view)

    private var cityList: List<City> = ArrayList()

    fun setLocationList(listLocMinsk: List<City>){
        this.cityList = listLocMinsk
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val bindView = holder.itemView
        bindView.item_name_city.text = cityList[position].title
    }
}