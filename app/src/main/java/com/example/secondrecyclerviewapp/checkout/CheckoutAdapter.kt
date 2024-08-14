package com.example.secondrecyclerviewapp.checkout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondrecyclerviewapp.Model
import com.example.secondrecyclerviewapp.R

class CheckoutAdapter (var FoodList : ArrayList<Model>) : RecyclerView.Adapter<CheckoutAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var foodName = itemView.findViewById<TextView>(R.id.checkoutFoodName)
        var foodQuantity = itemView.findViewById<TextView>(R.id.checkoutFoodQuantity)
        var foodPrice = itemView.findViewById<TextView>(R.id.checkoutFoodPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.checkout_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return FoodList.size
    }

    override fun onBindViewHolder(holder: CheckoutAdapter.ViewHolder, position: Int) {
        val item = FoodList[position]

        if (item.quantity == 0) {
            holder.itemView.visibility = View.GONE
            holder.itemView.layoutParams =
                RecyclerView.LayoutParams(
                    0,0
                )
        } else {
            holder.itemView.visibility = View.VISIBLE
            holder.itemView.layoutParams =
                RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

            holder.foodName.text = item.foodTitle
            holder.foodQuantity.text = item.quantity.toString()
            holder.foodPrice.text = "$" + "%.2f".format(item.price)
        }
    }
}