package com.example.marvel.data.network.dto

data class Comic(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
