package com.example.eventbus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.eventbus.databinding.ActivityMainBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {
    private var cartEventList: ArrayList<CartItem> = ArrayList()
    lateinit var activityMainBinding:ActivityMainBinding
    override fun onStart() {
        super.onStart()
        GlobusEventBus().getBus()?.register(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.button.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddCartActiviity::class.java))
        }
    }

    @Subscribe
    public fun onCartItemAdd(cartEvent: CartItem) {
        cartEventList.add(cartEvent)
        val cartTotalItems = "Cart Items: " + cartEventList.size;
        activityMainBinding.cartTextView.text = cartTotalItems;
        Toast.makeText(this, "Item added to cart.", Toast.LENGTH_SHORT).show();
    }
    override fun onDestroy() {
        super.onDestroy()
        GlobusEventBus().getBus()?.unregister(this)

    }

}