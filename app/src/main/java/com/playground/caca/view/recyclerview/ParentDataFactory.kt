package com.playground.caca.view.recyclerview

import com.playground.caca.model.ParentModel
import java.util.*

object ParentDataFactory {

    private val random = Random()

    private val titles = arrayListOf("New Arrival", "Recommended for you", "Suggested for you", "Just updated")

    private fun randomTitle(): String {
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    fun getParents(count: Int): MutableList<ParentModel> {
        val parents = mutableListOf<ParentModel>()

        repeat(count) {
            parents.add(ParentModel(randomTitle(), ChildDataFactory.getChildren(20)))
        }

        return parents
    }


}