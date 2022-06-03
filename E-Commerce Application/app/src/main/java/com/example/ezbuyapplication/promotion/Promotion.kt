package com.example.ezbuyapplication.promotion

class Promotion (image : String?) {

    private var image : String? = null

    init {
        this.image = image
    }

    public fun getImagePHD() : String?{
        return this.image
    }

}