package com.example.ezbuyapplication.promotion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ezbuyapplication.R
import com.google.firebase.database.*

class PromotionRecyclerViewFragment : Fragment() {

    private var promotionList = ArrayList<Promotion>()
    private var recyclerView : RecyclerView? = null
    private lateinit var promotionAdapter : PromotionHotDealsRecyclerViewAdapter

    //Database variables
    private var database : FirebaseDatabase? = null
    private var reference : DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_promotion_recycler_view, container, false)

        database = FirebaseDatabase.getInstance()
        reference = database?.getReference("promotionHotDeals")

        //Read Firebase
        val firebaseListener = object : ValueEventListener {

            //These two methods are override of ValueEventListener
            override fun onDataChange(snapshot: DataSnapshot) {

                val child = snapshot.children
                child.forEach{

                    var promotion = Promotion(it.child("image").value.toString())
                    promotionList.add(promotion)
                }

                val rcyViewAdapter = PromotionHotDealsRecyclerViewAdapter(promotionList)
                recyclerView?.adapter = rcyViewAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("text", error.message)
            }
        }

        reference?.addValueEventListener(firebaseListener)

        //Add to implement the fragment into which recycle view
        recyclerView = view.findViewById(R.id.rcyView_Promotion)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)

        promotionAdapter = PromotionHotDealsRecyclerViewAdapter(promotionList)
        recyclerView?.adapter = promotionAdapter

        return view
    }
}