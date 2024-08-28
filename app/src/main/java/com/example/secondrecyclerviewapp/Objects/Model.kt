package com.example.secondrecyclerviewapp.Objects

import java.io.Serializable


data class Model(
    var foodImage:Int,
    var foodTitle:String,
    var quantity:Int,
    var price:Double,
    var vendorId:Int
) : Serializable
