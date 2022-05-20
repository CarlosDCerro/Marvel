package com.example.marvel;

import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.util.common.Thumbnail

object TestMovieCharacterData {
        fun getMovieCharacterData(): List<MovieCharacter> {
        return listOf(MovieCharacter(
                id = 1,
                name = "Spiderman",
                description = "description",
                thumbnail = Thumbnail("ext", "path"),
                comics = null
        ))
        }
}
