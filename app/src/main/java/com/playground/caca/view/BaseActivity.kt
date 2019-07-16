package com.playground.caca.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun initComponent()

    abstract fun initListener()
}