package com.example.ezbuyapplication.promotion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ezbuyapplication.R
import com.squareup.picasso.Picasso

class PromotionHotDealsViewHolder (view : View) : RecyclerView.ViewHolder(view) {

    var image : ImageView = view.findViewById(R.id.imageViewPromotion)

}

class PromotionHotDealsRecyclerViewAdapter (private var promotionList : MutableList<Promotion>) : RecyclerView.Adapter<PromotionHotDealsViewHolder>() {

    //Return layout file
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionHotDealsViewHolder {
        val promotionHotDealsLayout = LayoutInflater.from(parent.context).inflate(R.layout.fragment_promotion, parent, false)

        return PromotionHotDealsViewHolder(promotionHotDealsLayout)
    }

    override fun onBindViewHolder(holder: PromotionHotDealsViewHolder, position: Int) {

        Picasso.get().load(promotionList[position].getImagePHD()).into(holder.image)

    }

    override fun getItemCount(): Int {
        return promotionList.size
    }
}