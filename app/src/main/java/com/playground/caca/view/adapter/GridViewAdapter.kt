package com.playground.caca.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playground.caca.R
import com.playground.caca.model.ChildModel
import com.playground.caca.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_rv_grid.*

class GridViewAdapter(
    private val items: MutableList<ChildModel>
) : RecyclerView.Adapter<GridViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = parent.inflate(R.layout.item_rv_grid)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(items[position])
    }


    class MyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(item: ChildModel) = with(item) {
            tvAppName.text = title
            imgAppLogo.setImageResource(childLogo)
        }
    }
}