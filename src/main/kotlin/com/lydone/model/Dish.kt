package com.lydone.model

import kotlinx.serialization.Serializable

@Serializable
data class Dish(
    val id: Int,
    val url: String,
    val name: String,
    val description: String,
    val price: Int,
    val weight: Int,
    val categoryId: Int
)