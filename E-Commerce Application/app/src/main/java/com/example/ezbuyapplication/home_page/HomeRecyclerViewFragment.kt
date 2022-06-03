package com.example.ezbuyapplication.home_page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ezbuyapplication.R
import com.google.firebase.database.*


class HomeRecyclerViewFragment : Fragment() {

    //Product Object
    private var productList = ArrayList<Product>()
    private var recyclerView: RecyclerView? = null
    private lateinit var productAdapter: ProductRecyclerViewAdapter

    //Database variable
    private var database: FirebaseDatabase? = null
    private var reference: DatabaseReference? = null

    private lateinit var btnSearch: Button
    private lateinit var editTextSearch: EditText

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_recycler_view, container, false)

        recyclerView = view.findViewById(R.id.rcyView_Home)     //Get Recycler View Id
        btnSearch = view.findViewById(R.id.buttonSearch)
        editTextSearch = view.findViewById(R.id.editTextSearch)

        firebaseAddProduct()

        var searchKey = editTextSearch.text.toString().trim()
        btnSearch.setOnClickListener {
            if (editTextSearch.text.toString().isNotEmpty()) {

                search(searchKey)   //Search Product
                Log.d("Message", "Search Button")
            }
        }
        return view
    }


    private fun firebaseAddProduct() {
        /* Compulsory to call reference and getInstance */
        database = FirebaseDatabase.getInstance()
        reference = database?.getReference("product")

        //Read Firebase
        val firebaseListener = object : ValueEventListener {

            //These two methods are override of ValueEventListener
            override fun onDataChange(snapshot: DataSnapshot) {

                val child = snapshot.children
                productList.clear()
                child.forEach {

                    var product = Product(
                        it.child("image").value.toString(),
                        it.child("name").value.toString(),
                        it.child("price").value.toString()
                    )
                    productList.add(product)
                }

                val rcyViewAdapter = ProductRecyclerViewAdapter(requireContext(), productList)
                recyclerView?.adapter = rcyViewAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("text", error.message)
            }
        }

        reference?.addValueEventListener(firebaseListener)      //Add Listener to the reference

        //Add to implement the fragment into which recycle view
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)  //2 column design

        productAdapter = ProductRecyclerViewAdapter(requireContext(), productList)
        recyclerView?.adapter = productAdapter
    }

    //Search Function
    private fun search(keyword: String) {

        //Query Of the firebase
        var firebaseQuery: Query = reference!!.orderByChild("name").startAt(keyword).endAt(keyword + "\uf8ff")

        var newProductList = ArrayList<Product>()

        firebaseQuery.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val child = snapshot.children

                child.forEach {

                        var products = Product(
                            it.child("image").value.toString(),
                            it.child("name").value.toString(),
                            it.child("price").value.toString()

                        )
                        newProductList.add(products)

                }

                val rcyViewAdapter = ProductRecyclerViewAdapter(requireContext(), newProductList)
                rcyViewAdapter.notifyDataSetChanged()
                recyclerView?.adapter = rcyViewAdapter

            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("text", error.message)
            }
        })

        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        productAdapter = ProductRecyclerViewAdapter(requireContext(), productList)
        recyclerView?.adapter = productAdapter

    }
}
