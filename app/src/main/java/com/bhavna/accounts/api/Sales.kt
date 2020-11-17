package com.bhavna.accounts.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class Sale {

    @SerializedName("_id")
    @Expose
    private var id: String? = null

    @SerializedName("client")
    @Expose
    private var client: String? = null

    @SerializedName("item")
    @Expose
    private var item: String? = null

    @SerializedName("quantity")
    @Expose
    private var quantity: Int? = null

    @SerializedName("unit")
    @Expose
    private var unit: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("totalPrice")
    @Expose
    private var totalPrice: Int? = null

    @SerializedName("date")
    @Expose
    private var date: String? = null

    @SerializedName("__v")
    @Expose
    private var v: Int? = null

    fun getId(): String? {
        return id;
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getClient(): String? {
        return client
    }

    fun setClient(client: String) {
        this.client = client
    }

    fun getItem(): String? {
        return item
    }

    fun setItem(item: String) {
        this.item = item;
    }

    fun getQuantity(): Int? {
        return quantity
    }

    fun setQuantity(quantity: Int) {
        this.quantity = quantity;
    }

    fun getUnit(): String? {
        return unit;
    }

    fun setUnit(unit: String) {
        this.unit = unit
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getTotalPrice(): Int? {
        return totalPrice
    }

    fun setTotalPrice(totalPrice: Int) {
        this.totalPrice = totalPrice
    }

    fun getDate(): String?{
        return date
    }

    fun setDate(date: String) {
        this.date = date
    }

    fun getV(): Int?{
        return v
    }

    fun setV (v: Int) {
        this.v = v
    }

}