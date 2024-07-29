package com.example.secondrecyclerviewapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondrecyclerviewapp.checkout.CheckoutAdapter
import com.example.secondrecyclerviewapp.databinding.ActivityCheckoutOnePerRowBinding

class CheckoutActivity : AppCompatActivity() {

    private lateinit var activityCheckoutOnePerRowBinding: ActivityCheckoutOnePerRowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodList = intent.getSerializableExtra("checkout_food_list") as ArrayList<Model>

        activityCheckoutOnePerRowBinding = ActivityCheckoutOnePerRowBinding.inflate(layoutInflater)
        setContentView(activityCheckoutOnePerRowBinding.root)

        activityCheckoutOnePerRowBinding.checkoutRecyclerview.adapter = CheckoutAdapter(foodList)
        activityCheckoutOnePerRowBinding.checkoutRecyclerview.layoutManager = LinearLayoutManager(this)



        activityCheckoutOnePerRowBinding.newPurchaseButton.setOnClickListener {
            val newPurchaseIntent = Intent(this, MainActivity::class.java)
            startActivity(newPurchaseIntent)
        }


    }
}