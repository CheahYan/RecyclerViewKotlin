package com.example.secondrecyclerviewapp

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondrecyclerviewapp.databinding.ActivityMainBinding
import com.example.secondrecyclerviewapp.databinding.ItemLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var itemLayoutBinding: ItemLayoutBinding
    private val foodList = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        itemLayoutBinding = ItemLayoutBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        activityMainBinding.mainRecyclerview.adapter = MainAdapter(foodList, supportFragmentManager)

        activityMainBinding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
        var switch_flag = true
        activityMainBinding.oneTwoItemsSwitch.setOnClickListener {
            if (switch_flag) {
                activityMainBinding.mainRecyclerview.layoutManager = GridLayoutManager(this, 2)
                activityMainBinding.oneTwoItemsSwitch.text = "Two Items Per Row"
                
                replaceFragment(switch_flag)

                switch_flag = !switch_flag
            } else {
                activityMainBinding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
                activityMainBinding.oneTwoItemsSwitch.text = "One Item Per Row"

                replaceFragment(switch_flag)

                switch_flag = !switch_flag
            }
        }


        foodList.add(Model(R.drawable.food_apple_pie, "Apple Pie", 0))
        foodList.add(Model(R.drawable.food_avocados, "Avocados", 0))
        foodList.add(Model(R.drawable.food_burger, "Burger", 0))
        foodList.add(Model(R.drawable.food_chicken_tenders, "Chicken Tenders", 0))
        foodList.add(Model(R.drawable.food_fish_and_chips, "Fish And Chips", 0))
        foodList.add(Model(R.drawable.food_deep_dish_pizza, "Deep Dish Pizza", 0))
        foodList.add(Model(R.drawable.food_escargot, "Escargot", 0))
        foodList.add(Model(R.drawable.food_fried_chicken, "Fried Chicken", 0))
        foodList.add(Model(R.drawable.food_grilled_cheese_toast, "Grill Cheese Toast", 0))
        foodList.add(Model(R.drawable.food_mapo_tofu, "Mapo Tofu", 0))
        foodList.add(Model(R.drawable.food_pancakes, "Pancake", 0))
        foodList.add(Model(R.drawable.food_ramen, "Ramen", 0))
        foodList.add(Model(R.drawable.food_rigatoni_pasta, "Rigatoni Pasta", 0))
        foodList.add(Model(R.drawable.food_waffles, "Waffles", 0))
        foodList.add(Model(R.drawable.food_watermelon, "Watermelon", 0))
        foodList.add(Model(R.drawable.food_grilled_duck_drumstick, "Grilled Duck Drumstick", 0))
        foodList.add(Model(R.drawable.food_ham_and_cheese_sandwich, "Ham And Cheese Sandwich", 0))
        foodList.add(Model(R.drawable.food_honey_garlic_prawns_with_broccoli_and_rice, "Honey Garlic Prawns" +
                " With Broccoli And Rice", 0))
        foodList.add(Model(R.drawable.food_jollibee_fried_chicken_sandwich, "Jollibee Fried Chicken Sandwich", 0))
        foodList.add(Model(R.drawable.food_lasagna, "Lasagna", 0))
        foodList.add(Model(R.drawable.food_macaroni, "Macaroni", 0))
        foodList.add(Model(R.drawable.food_masala_thosai, "Masala Thosai", 0))
        foodList.add(Model(R.drawable.food_pizza, "Pizza", 0))
        foodList.add(Model(R.drawable.food_potato_chips, "Potato Chips", 0))
        foodList.add(Model(R.drawable.food_strawberry, "Strawberry", 0))
        foodList.add(Model(R.drawable.food_strawberry_milk, "Strawberry Milk", 0))
        foodList.add(Model(R.drawable.food_strawberry_shortcake, "Strawberry Shortcake", 0))

        activityMainBinding.checkoutButton.setOnClickListener {
            val goCheckoutIntent = Intent(this, CheckoutActivity::class.java)
            goCheckoutIntent.putExtra("checkout_food_list", foodList)
            startActivity(goCheckoutIntent)
        }
    }

    private fun replaceFragment(isCurrentlyOne: Boolean) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (isCurrentlyOne) {
            fragmentTransaction.replace(R.id.foodImageFragmentContainer, SecondFragment())
            fragmentTransaction.commit()
        } else {
            fragmentTransaction.replace(R.id.foodImageFragmentContainer, FirstFragment())
            fragmentTransaction.commit()
        }
    }
}