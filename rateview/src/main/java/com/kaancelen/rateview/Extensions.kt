package com.kaancelen.rateview

import android.view.View

fun View.preventClickRush(){
    this.isEnabled = false
    this.postDelayed({
        this.isEnabled = true
    }, 500L)
}