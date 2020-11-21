package com.bhavna.accounts.ui.home

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhavna.accounts.R
import com.bhavna.accounts.api.Sale
import com.bhavna.accounts.api.SalesAPIInterface
import kotlinx.android.synthetic.main.fragment_client.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ClientFragment() : Fragment() {
    private val apiKey = "d7d8d35fa42b4a8d827eb143bce6be1e"
    private val TAG = "ClientFragment"
    var root: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_client, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                        Log.i(TAG, "onResponse: " + (sale.size))
                    }

                    recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

                    var adapter = RecyclerAdapter(activity!!.supportFragmentManager, sale)

                    recyclerView.adapter = adapter
                }

            })

        }
    }

}