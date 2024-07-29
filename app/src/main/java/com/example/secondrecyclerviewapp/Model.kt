package com.example.secondrecyclerviewapp

import java.io.Serializable


data class Model(
    var foodImage:Int,
    var foodTitle:String,
    var quantity:Int
) : Serializable
