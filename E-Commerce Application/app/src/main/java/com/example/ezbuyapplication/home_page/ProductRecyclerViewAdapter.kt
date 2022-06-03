package com.example.ezbuyapplication.home_page

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ezbuyapplication.R
import com.example.ezbuyapplication.payment.Payment
import com.squareup.picasso.Picasso

class ProductRecyclerViewAdapter(
    val c : Context,
    private var productList: MutableList<Product>) : RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>(){

    //Return layout file
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_product_list, parent, false)

        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productItem = productList[position]

        Picasso.get().load(productList[position].getImage()).into(holder.image)
        holder.name.text = productItem.getProductName()
        holder.price.text = productItem.getPrice()

        holder.addBtn.setOnClickListener {

            var intent : Intent? = null
            intent = Intent(c, Payment::class.java)
            intent!!.putExtra("image", productList.get(position).getImage())
            intent!!.putExtra("name", productList.get(position).getProductName())
            intent!!.putExtra("price", productList.get(position).getPrice())
            c.startActivity(intent)
        }

    }

    //Return total number of record in the productList List
    override fun getItemCount(): Int {
        return productList.size
    }

    //View Holder class
    class ProductViewHolder (view : View) : RecyclerView.ViewHolder(view){

        var image : ImageView = view.findViewById(R.id.imageProduct)
        var name : TextView = view.findViewById(R.id.txtViewProductName)
        var price : TextView = view.findViewById(R.id.txtViewPrice)
        var addBtn : Button = view.findViewById(R.id.buttonAdd)

    }
}