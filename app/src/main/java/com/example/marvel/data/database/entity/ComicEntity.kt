package com.example.marvel.data.database.entity;

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvel.data.network.dto.Item

@Entity
data class ComicEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
    )
