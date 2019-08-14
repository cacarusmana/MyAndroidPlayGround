package com.playground.caca.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.playground.caca.R
import kotlinx.android.synthetic.main.activity_shimmer.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ShimmerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shimmer)

    }

    override fun onResume() {
        super.onResume()
        layoutShimmer.startShimmerAnimation()
    }

    override fun onPause() {
        super.onPause()
        layoutShimmer.stopShimmerAnimation()
    }

}