package com.example.eventbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class AddCartActiviity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_cart_activiity)
        var addItem1=findViewById<Button>(R.id.addItem1)
        var addItem2=findViewById<Button>(R.id.addItem2)
        GlobusEventBus().getBus()?.register(this)

    }

    @Subscribe
    fun addItemToCart(view:View){
        EventBus.getDefault().post(CartItem("Added"))
    }
    override fun onDestroy() {
        super.onDestroy()
        GlobusEventBus().getBus()?.unregister(this)

    }

}