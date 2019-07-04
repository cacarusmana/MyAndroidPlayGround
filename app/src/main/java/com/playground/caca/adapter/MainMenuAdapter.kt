package com.playground.caca.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.playground.caca.R
import com.playground.caca.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_main_menu.*

class MainMenuAdapter(
    private val context: Context,
    private val items: MutableList<String>,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<MainMenuAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        return MyViewHolder(parent.inflate(R.layout.item_main_menu))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.bindItem(items[position], listener)
    }


    class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(menuName: String, listener: (String) -> Unit) {
            tvMenuName.text = menuName
            containerView.setOnClickListener { listener(menuName) }
        }
    }
}