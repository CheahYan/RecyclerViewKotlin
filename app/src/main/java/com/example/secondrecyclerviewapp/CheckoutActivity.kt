package com.example.secondrecyclerviewapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondrecyclerviewapp.checkout.CheckoutAdapter
import com.example.secondrecyclerviewapp.databinding.ActivityCheckoutOnePerRowBinding

class CheckoutActivity : AppCompatActivity() {

    private lateinit var activityCheckoutOnePerRowBinding: ActivityCheckoutOnePerRowBinding
    private val SERVICE_CHARGE_RATE = 0.10
    private val GST_RATE = 0.08

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val foodList = intent.getSerializableExtra("checkout_food_list") as ArrayList<Model>

        activityCheckoutOnePerRowBinding = ActivityCheckoutOnePerRowBinding.inflate(layoutInflater)
        setContentView(activityCheckoutOnePerRowBinding.root)

        activityCheckoutOnePerRowBinding.checkoutRecyclerview.adapter = CheckoutAdapter(foodList)
        activityCheckoutOnePerRowBinding.checkoutRecyclerview.layoutManager = LinearLayoutManager(this)

        val subtotal = calculateSubtotal(foodList)
        activityCheckoutOnePerRowBinding.subtotalAmount.text = "$" + "%.2f".format(subtotal)

        val serviceCharge = calculateServiceCharge(subtotal)
        activityCheckoutOnePerRowBinding.serviceChargeAmount.text = "$" + "%.2f".format(serviceCharge)

        val goodsAndServiceTax = calculateGST(subtotal)
        activityCheckoutOnePerRowBinding.GSTAmount.text = "$" + "%.2f".format(goodsAndServiceTax)


        val total = calculateTotal(subtotal, goodsAndServiceTax, serviceCharge)
        activityCheckoutOnePerRowBinding.totalAmount.text = "$" + "%.2f".format(total)

        activityCheckoutOnePerRowBinding.newPurchaseButton.setOnClickListener {
            val newPurchaseIntent = Intent(this, MainActivity::class.java)
            startActivity(newPurchaseIntent)
        }


    }

    fun calculateSubtotal(foodList : ArrayList<Model>): Double {
        var result = 0.00
        for (food in foodList) {
            result = result + (food.price * food.quantity)
        }

        return result
    }

    fun calculateServiceCharge(subtotal: Double): Double {
        return subtotal * SERVICE_CHARGE_RATE
    }

    fun calculateGST(subtotal: Double): Double {
        return subtotal * GST_RATE
    }

    fun calculateTotal(subtotal: Double, serviceCharge: Double, gst: Double): Double {
        return subtotal + serviceCharge + gst
    }
}