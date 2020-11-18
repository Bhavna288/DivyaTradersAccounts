package com.bhavna.accounts.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bhavna.accounts.R
import com.bhavna.accounts.api.Sale
import java.time.format.DateTimeFormatter

class RecyclerAdapter(private val activity: FragmentActivity?, private val sale: ArrayList<Sale?>?) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var saleItem: RelativeLayout = itemView.findViewById(R.id.sale_item)
        var tv1: TextView = itemView.findViewById(R.id.textView)
        var tv2: TextView = itemView.findViewById(R.id.textView2)
        var tv3: TextView = itemView.findViewById(R.id.textView3)
        var tv4: TextView = itemView.findViewById(R.id.textView4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.sale_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (sale != null) {
            return sale.size
        }
        return 0
    }

    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("TAG", "onBindViewHolder: " + sale?.get(position)?.client?.name, null)
        if (sale != null) {
            val client = sale.get(position)?.client?.name
            var date1 = sale.get(position)?.date
            val price = sale.get(position)?.totalPrice?: 0
            val quantity = sale.get(position)?.quantity?: 0

            holder.tv1.setText(client)
            holder.tv3.setText(date1)
            holder.tv2.setText(price.toString())
            holder.tv4.setText(quantity.toString())

            holder.saleItem.setOnClickListener(View.OnClickListener { view ->
                var fragmentManager: FragmentManager? = activity?.supportFragmentManager
                val transaction = fragmentManager?.beginTransaction()
                if (transaction != null) {
                    transaction.replace(R.layout.fragment_client, ClientDetails())
                    transaction.disallowAddToBackStack()
                    transaction.commit()
                }
            })
        }
    }
}