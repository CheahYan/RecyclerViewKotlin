package com.example.secondrecyclerviewapp.Objects

import java.io.Serializable


data class Item(
    var name:String,
    var image:String,
    var price:Double,
    var vendorId:Int
) : Serializable
