package com.example.secondrecyclerviewapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class MainAdapter (
    var FoodList : ArrayList<Model>,
    var fragmentManager: FragmentManager
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var fragmentContainerView: FragmentContainerView = itemView.findViewById<FragmentContainerView>(R.id.foodImageFragmentContainer)
        var foodName = itemView.findViewById<TextView>(R.id.foodName)
        var foodQuantity = itemView.findViewById<TextView>(R.id.foodQuantity)

        var incrementButton = itemView.findViewById<ImageButton>(R.id.incrementButton)
        var decrementButton = itemView.findViewById<ImageButton>(R.id.decrementButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return FoodList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = FoodList[position]


        holder.foodName.text = item.foodTitle
        holder.foodQuantity.text = item.quantity.toString()

        var counter:Int = item.quantity

        holder.incrementButton.setOnClickListener {
            counter = counter + 1

            item.quantity = counter
            holder.foodQuantity.text = item.quantity.toString()

        }

        holder.decrementButton.setOnClickListener {
            if (counter > 0) {
                counter = counter - 1

                item.quantity = counter
                holder.foodQuantity.text = item.quantity.toString()
            }
        }
    }
}