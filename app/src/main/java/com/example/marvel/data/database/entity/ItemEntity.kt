package com.example.marvel.data.database.entity;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val resourceURI: String
)

