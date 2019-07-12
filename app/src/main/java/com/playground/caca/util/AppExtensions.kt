package com.playground.caca.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


fun ViewGroup.inflate(resourceId: Int): View {
    return LayoutInflater.from(context).inflate(resourceId, this, false)
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

fun Context.dp(dpValue: Int): Int {
    val scale = resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

fun View.margin(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0) {
    val params = ViewGroup.MarginLayoutParams(layoutParams).apply {
        setMargins(left, top, right, bottom)
    }

    layoutParams = params
}