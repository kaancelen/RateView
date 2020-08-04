package com.kaancelen.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kaancelen.rateview.RateView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rateView = findViewById<RateView>(R.id.rate_view)
        rateView.onChangeListener {
            Toast.makeText(this, "Selected $it", Toast.LENGTH_LONG).show()
        }
    }
}
