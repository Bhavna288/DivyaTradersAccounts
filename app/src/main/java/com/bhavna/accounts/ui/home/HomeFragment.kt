package com.bhavna.accounts.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhavna.accounts.R
import com.bhavna.accounts.api.Sale
import com.bhavna.accounts.api.SalesAPIInterface
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    var TAG: String = "HomeFragment"
    private val apiKey = "d7d8d35fa42b4a8d827eb143bce6be1e"

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val retrofit = Retrofit.Builder()
            .baseUrl("https://divyatradersaccounts-apim.azure-api.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: SalesAPIInterface = retrofit.create(SalesAPIInterface::class.java)

        val call: Call<ArrayList<Sale?>>? = api.getSales(apiKey)

        if (call != null) {
            call.enqueue(object : Callback<ArrayList<Sale?>> {
                override fun onFailure(call: Call<ArrayList<Sale?>>, t: Throwable) {
                    Log.e(TAG, "onFailure: " + t.message, null)
                }

                override fun onResponse(call: Call<ArrayList<Sale?>>, response: Response<ArrayList<Sale?>>) {
                    if (!response.isSuccessful()) {
                        Log.d(TAG, "instance initializer: " + response.message())
                        return
                    }

                    var sale: ArrayList<Sale?>? = response.body()
                    if (sale != null) {
                        Log.i(TAG, "onResponse: " + (sale.get(0)?.getClient() ?: ""))
                    }

                    recyclerView.layoutManager = LinearLayoutManager(root.context, RecyclerView.VERTICAL, false)

                    var adapter = RecyclerAdapter(root.context, sale)

                    recyclerView.adapter = adapter
                }

            })


        }
        return root

    }
}