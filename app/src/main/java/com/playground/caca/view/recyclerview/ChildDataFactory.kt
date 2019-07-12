package com.playground.caca.view.recyclerview

import com.playground.caca.R
import com.playground.caca.model.ChildModel
import java.util.*

object ChildDataFactory {

    private val random = Random()

    private val childrenName = arrayListOf("Facebook", "Twitter", "Instagram", "Telegram", "WhatsApp")
    private val childrenLogo =
        arrayListOf(R.drawable.facebook_logo_300, R.drawable.twitter_logo_300, R.drawable.instagram_logo_300)

    private fun randomChildrenName(): String {
        val index = random.nextInt(childrenName.size)
        return childrenName[index]
    }

    private fun randomChildrenLogo(): Int {
        val index = random.nextInt(childrenLogo.size)
        return childrenLogo[index]
    }

    fun getChildren(count: Int): MutableList<ChildModel> {
        val children = mutableListOf<ChildModel>()

        repeat(count) {
            children.add(ChildModel(randomChildrenName(), randomChildrenLogo()))
        }

        return children
    }

}