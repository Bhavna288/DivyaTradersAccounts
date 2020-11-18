package com.bhavna.accounts.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhavna.accounts.R
import com.bhavna.accounts.api.Sale

class RecyclerAdapter(private val mContext: Context?, private val sale: ArrayList<Sale?>?) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("TAG", "onBindViewHolder: " + sale?.get(position)?.client?.name, null)
        if (sale != null) {
            val client = sale.get(position)?.client?.name
            val date1 = sale.get(position)?.date
            val price = sale.get(position)?.totalPrice?: 0
            val quantity = sale.get(position)?.quantity?: 0

            holder.tv1.setText(client)
            holder.tv3.setText(date1)
            holder.tv2.setText(price.toString())
            holder.tv4.setText(quantity.toString())
        }
    }
}