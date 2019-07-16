package com.playground.caca.view.recyclerview

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.playground.caca.R
import com.playground.caca.view.BaseActivity
import com.playground.caca.view.adapter.ParentModelAdapter
import kotlinx.android.synthetic.main.activity_nested_recyclerview.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class NestedRecyclerViewActivity : BaseActivity() {

    private lateinit var parentsAdapter: ParentModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_recyclerview)

        initComponent()
    }

    override fun initComponent() {
        parentsAdapter = ParentModelAdapter(this, mutableListOf())

        rvParents.apply {
            layoutManager = LinearLayoutManager(
                this@NestedRecyclerViewActivity,
                RecyclerView.VERTICAL,
                false
            )
            adapter = parentsAdapter
        }

        GlobalScope.launch(Dispatchers.Main) {
            val parents = withContext(Dispatchers.Default) {
                ParentDataFactory.getParents(20)
            }

            parentsAdapter.notifyChanges(parents)
        }

    }

    override fun initListener() {

    }

}