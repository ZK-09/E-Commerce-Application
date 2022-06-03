package com.example.ezbuyapplication.home_page

class Product (image : String?, name : String?, price : String) {

    private var image : String? = null
    private var name : String? = null
    private var price : String? = null
    private var status : String = "Purchase Successfully"

    //Constructor
    init {
        this.image = image
        this.name = name
        this.price = price
    }

    //Methods
    public fun getImage() : String? {
        return this.image
    }

    public fun getProductName() : String? {
        return this.name
    }

    public fun getPrice() : String? {
        return this.price
    }

    public fun getStatus() : String{
        return status
    }



}