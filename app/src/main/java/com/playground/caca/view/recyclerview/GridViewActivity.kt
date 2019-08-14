package com.playground.caca.view.recyclerview

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.playground.caca.R
import com.playground.caca.view.BaseActivity
import com.playground.caca.view.adapter.GridViewAdapter
import kotlinx.android.synthetic.main.activity_nested_recyclerview.*

class GridViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_recyclerview)

        initComponent()
        initListener()
    }

    override fun initComponent() {
        val gridAdapter = GridViewAdapter(ChildDataFactory.getChildren(13))

        rvParents.apply {
            layoutManager = GridLayoutManager(this@GridViewActivity, 3)
            adapter = gridAdapter
        }


    }

    override fun initListener() {

    }
}