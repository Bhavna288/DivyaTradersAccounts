package com.bhavna.accounts.ui.home

import android.content.ContentValues.TAG
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import com.bhavna.accounts.R
import com.bhavna.accounts.`interface`.BackPressed
import com.bhavna.accounts.api.Sale
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_client_details.*

class ClientDetails(var id: String?, var sale: List<Sale?>?) : Fragment(), BackPressed {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_client_details, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.findViewById<Spinner>(R.id.spinner)?.visibility = View.GONE
        activity?.findViewById<TextView>(R.id.pg_title)?.visibility = View.VISIBLE

        val details = sale?.filter { s -> s?.client?.id == id }
        activity?.findViewById<TextView>(R.id.pg_title)?.text = details?.get(0)?.client?.name
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.setBackgroundColor(resources.getColor(R.color.colorAccent))
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.setNavigationIcon(R.drawable.back_btn)

        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.setNavigationOnClickListener{
            activity?.onBackPressed()
        }

        var recAmt:Int? = 0

        if (recAmt != null) {
            for (i in 0 until details?.size!!) {
                recAmt += details.get(i)?.remainingBalance!!
            }
        }
        rec_amt.setText("₹ " + recAmt.toString())

    }

    override fun onBackPressed(): Boolean {
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.setNavigationIcon(null)
        activity?.findViewById<Spinner>(R.id.spinner)?.visibility = View.VISIBLE
        activity?.findViewById<TextView>(R.id.pg_title)?.visibility = View.GONE
        return true
    }

}