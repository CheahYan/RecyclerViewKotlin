package com.example.secondrecyclerviewapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondrecyclerviewapp.databinding.ActivityMainBinding
import com.example.secondrecyclerviewapp.databinding.ItemLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var itemLayoutBinding: ItemLayoutBinding
    private lateinit var adapter: MainAdapter
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

        adapter = MainAdapter(foodList)
        activityMainBinding.mainRecyclerview.adapter = adapter


        activityMainBinding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
        var isBigImage = true
        activityMainBinding.oneTwoItemsSwitch.setOnClickListener {
            if (isBigImage) {
                activityMainBinding.mainRecyclerview.layoutManager = GridLayoutManager(this, 2)
                activityMainBinding.oneTwoItemsSwitch.text = "Two Items Per Row"


                adapter.updateImageWidthAndHeight(200)

                isBigImage = !isBigImage
            } else {
                activityMainBinding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
                activityMainBinding.oneTwoItemsSwitch.text = "One Item Per Row"

                adapter.updateImageWidthAndHeight(400)

                isBigImage = !isBigImage
            }
        }


        foodList.add(Model(R.drawable.food_apple_pie, "Apple Pie", 0, 2.40))
        foodList.add(Model(R.drawable.food_avocados, "Avocados", 0, 1.11))
        foodList.add(Model(R.drawable.food_burger, "Burger", 0, 6.59))
        foodList.add(Model(R.drawable.food_chicken_tenders, "Chicken Tenders", 0, 1.80))
        foodList.add(Model(R.drawable.food_fish_and_chips, "Fish And Chips", 0, 11.80))
        foodList.add(Model(R.drawable.food_deep_dish_pizza, "Deep Dish Pizza", 0, 25.99))
        foodList.add(Model(R.drawable.food_escargot, "Escargot", 0, 0.50))
        foodList.add(Model(R.drawable.food_fried_chicken, "Fried Chicken", 0, 2.50))
        foodList.add(Model(R.drawable.food_grilled_cheese_toast, "Grill Cheese Toast", 0, 1.60))
        foodList.add(Model(R.drawable.food_mapo_tofu, "Mapo Tofu", 0, 8.40))
        foodList.add(Model(R.drawable.food_pancakes, "Pancake", 0, 2.30))
        foodList.add(Model(R.drawable.food_ramen, "Ramen", 0, 7.50))
        foodList.add(Model(R.drawable.food_rigatoni_pasta, "Rigatoni Pasta", 0, 8.90))
        foodList.add(Model(R.drawable.food_waffles, "Waffles", 0, 1.80))
        foodList.add(Model(R.drawable.food_watermelon, "Watermelon", 0, 5.60))
        foodList.add(Model(R.drawable.food_grilled_duck_drumstick, "Grilled Duck Drumstick", 0, 2.80))
        foodList.add(Model(R.drawable.food_ham_and_cheese_sandwich, "Ham And Cheese Sandwich", 0, 2.30))
        foodList.add(Model(R.drawable.food_honey_garlic_prawns_with_broccoli_and_rice, "Honey Garlic Prawns" +
                " With Broccoli And Rice", 0, 12.80))
        foodList.add(Model(R.drawable.food_jollibee_fried_chicken_sandwich, "Jollibee Fried Chicken Sandwich", 0, 6.75))
        foodList.add(Model(R.drawable.food_lasagna, "Lasagna", 0, 12.10))
        foodList.add(Model(R.drawable.food_macaroni, "Macaroni", 0, 6.40))
        foodList.add(Model(R.drawable.food_masala_thosai, "Masala Thosai", 0, 2.80))
        foodList.add(Model(R.drawable.food_pizza, "Pizza", 0, 32.90))
        foodList.add(Model(R.drawable.food_potato_chips, "Potato Chips", 0, 0.90))
        foodList.add(Model(R.drawable.food_strawberry, "Strawberry", 0, 0.23))
        foodList.add(Model(R.drawable.food_strawberry_milk, "Strawberry Milk", 0, 1.20))
        foodList.add(Model(R.drawable.food_strawberry_shortcake, "Strawberry Shortcake", 0, 2.50))

        activityMainBinding.checkoutButton.setOnClickListener {
            val goCheckoutIntent = Intent(this, CheckoutActivity::class.java)
            goCheckoutIntent.putExtra("checkout_food_list", foodList)
            startActivity(goCheckoutIntent)
        }


        activityMainBinding.testButton.setOnClickListener {
            //implicit intent to open the dialler with a number
            val intent = Intent("android.intent.action.NETSPOS")
            startActivity(intent)
        }

    }
}