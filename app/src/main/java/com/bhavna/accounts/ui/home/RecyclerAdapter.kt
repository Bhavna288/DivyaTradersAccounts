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

class RecyclerAdapter(private val mContext: Context, private val sale: ArrayList<Sale?>?) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv1: TextView = itemView.findViewById(R.id.textView)
        var tv2: TextView = itemView.findViewById(R.id.textView2)
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
        Log.e("TAG", "onBindViewHolder: " + sale?.get(position)?.getClient(), null)
        if (sale != null) {
            holder.tv1.setText(sale.get(position)?.getClient())
        }
    }
}