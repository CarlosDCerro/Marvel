package com.example.marvel.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.util.common.Thumbnail

@Entity(tableName = "character")
data class MovieCharacterEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @Embedded val thumbnail: Thumbnail
)

fun MovieCharacter.toEntity() = MovieCharacterEntity(id, name, description, thumbnail)


