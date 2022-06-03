package com.example.ezbuyapplication.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.ezbuyapplication.R
import com.squareup.picasso.Picasso

class Payment : AppCompatActivity() {

    private var sName: String? = null
    private var sImage: String? = null
    private var sPrice: String? = null
    private var amountQ: Int? = null


    private var image: ImageView? = null
    private var name: TextView? = null
    private var price: TextView? = null

    private var addImg: ImageView? = null
    private var minusImg: ImageView? = null
    private var priceTotal: TextView? = null
    private var quantity: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        image = findViewById(R.id.imgViewImageSC)
        name = findViewById(R.id.txtViewProductNameSC)
        price = findViewById(R.id.txtViewPriceSC)
        addImg = findViewById(R.id.imgViewAddSC)
        minusImg = findViewById(R.id.imgViewMinusSC)
        priceTotal = findViewById(R.id.txtViewTotalPrice)
        quantity = findViewById(R.id.txtViewAmountSC)

        val intent = intent
        sImage = intent.getStringExtra("image")
        sName = intent.getStringExtra("name")
        sPrice = intent.getStringExtra("price")

        Picasso.get().load(sImage).into(image)
        name!!.setText(sName)
        price!!.setText(sPrice)

        priceTotal!!.setText(sPrice)

        amountQ = 1
        quantity!!.setText(amountQ!!.toString())

    }
}

