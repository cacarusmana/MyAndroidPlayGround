package com.playground.caca.view.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.playground.caca.R
import com.playground.caca.util.toast
import com.playground.caca.view.BaseActivity
import com.playground.caca.view.adapter.MainMenuAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class RecyclerViewActivity : BaseActivity() {

    private lateinit var rvAdapter: MainMenuAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
    }

    override fun initComponent() {
        setSupportActionBar(toolbar)

        rvAdapter = MainMenuAdapter(this, resources.getStringArray(R.array.recycler_view_menu_array).toMutableList())

        rvMenu.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            adapter = rvAdapter
        }

        initListener()
    }

    override fun initListener() {
        rvAdapter.addListener { menuName, position ->
            if (position == 0) {
                startActivity(Intent(this@RecyclerViewActivity, NestedRecyclerViewActivity::class.java))
            } else {
                toast(menuName)
            }
        }

        fab.hide()
    }
}