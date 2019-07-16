package com.playground.caca.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playground.caca.R
import com.playground.caca.model.ChildModel
import com.playground.caca.util.dp
import com.playground.caca.util.inflate
import com.playground.caca.util.margin
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_rv_child.*

class ChildModelAdapter(
    private val children: List<ChildModel>
) : RecyclerView.Adapter<ChildModelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = parent.inflate(R.layout.item_rv_child)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(position, children[position])
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(position: Int, child: ChildModel) = with(child) {
            tvChildName.text = title
            imgChildLogo.setImageResource(childLogo)

            with(containerView) {

                when (position) {
                    0 -> margin(left = context.dp(5))
                    itemCount - 1 -> margin(right = context.dp(5))
                    else -> margin()
                }
            }
        }
    }

}