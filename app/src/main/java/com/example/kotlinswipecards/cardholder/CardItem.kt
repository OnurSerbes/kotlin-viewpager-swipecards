package com.example.fameapp.mainFragments.cardholder

import android.graphics.Bitmap

data class CardItem(

    var image: Bitmap,
    var name: String,
    var surname: String,
    val gender: String,
    val country: String,
    val birthdate: String,
    val validDate: String,


    )
