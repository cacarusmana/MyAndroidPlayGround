package com.playground.caca.view

import android.support.v7.app.AppCompatActivity

open abstract class BaseActivity : AppCompatActivity() {

    abstract fun initComponent()

    abstract fun initListener()
}