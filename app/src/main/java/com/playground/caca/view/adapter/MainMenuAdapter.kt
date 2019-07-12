package com.playground.caca.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.playground.caca.R
import com.playground.caca.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_rv_main.*

class MainMenuAdapter(
    private val context: Context,
    private val items: MutableList<String>
) : RecyclerView.Adapter<MainMenuAdapter.MyViewHolder>() {

    private lateinit var listener: (String, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        return MyViewHolder(parent.inflate(R.layout.item_rv_main))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.bindItem(position, items[position], listener)
    }

    fun addListener(listener: (String, Int) -> Unit) {
        this.listener = listener
    }

    inner class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(position: Int, menuName: String, listener: (String, Int) -> Unit) {
            tvMenuName.text = menuName
            containerView.setOnClickListener { listener(menuName, position) }
        }
    }
}