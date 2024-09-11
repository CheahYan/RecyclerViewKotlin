package com.example.secondrecyclerviewapp

import com.example.secondrecyclerviewapp.Objects.Item
import com.example.secondrecyclerviewapp.Objects.Vendor
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("vendors/{id}")
    fun getVendor(
        @Path("id") vendorId: Int
    ): Call<Vendor>

    @GET("vendors/{id}/items")
    fun getFoodItem(
        @Path("vendorId") vendorId: Int
    ): Call<List<Item>>

}