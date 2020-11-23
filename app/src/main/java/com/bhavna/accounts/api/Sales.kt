package com.bhavna.accounts.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Client {
    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}

class Item {
    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}

class Sale {
    @SerializedName("_id")
    @Expose
    var id: String? = null

    @SerializedName("client")
    @Expose
    var client: Client? = null

    @SerializedName("item")
    @Expose
    var item: Item? = null

    @SerializedName("quantity")
    @Expose
    var quantity: Int? = null

    @SerializedName("unit")
    @Expose
    var unit: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("totalPrice")
    @Expose
    var totalPrice: Int? = null

    @SerializedName("remainingBalance")
    @Expose
    var remainingBalance: Int? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("__v")
    @Expose
    var v: Int? = null

}