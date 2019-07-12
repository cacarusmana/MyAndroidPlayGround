package com.playground.caca.view.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.playground.caca.R
import com.playground.caca.model.ParentModel
import com.playground.caca.util.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_rv_parent.*

class ParentModelAdapter(
    private val context: Context,
    private val parents: MutableList<ParentModel>
) : RecyclerView.Adapter<ParentModelAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = parent.inflate(R.layout.item_rv_parent)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    fun notifyChanges(parents: MutableList<ParentModel>) {
        this.parents.clear()
        this.parents.addAll(parents)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(parents[position])
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(parent: ParentModel) = with(parent) {
            tvTitle.text = title

            rvChilds.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = ChildModelAdapter(children)
                setRecycledViewPool(viewPool)
            }
        }

    }
}