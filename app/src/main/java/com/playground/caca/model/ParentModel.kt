package com.playground.caca.model

data class ParentModel(
    val title: String = "",
    val children: MutableList<ChildModel> = mutableListOf()
)