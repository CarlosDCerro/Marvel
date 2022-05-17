package com.example.marvel.data.network.dto

import com.example.marvel.util.common.Thumbnail

data class MovieCharacterDTO(
    val comics: Comic,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)
