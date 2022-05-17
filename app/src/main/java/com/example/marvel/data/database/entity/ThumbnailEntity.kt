package com.example.marvel.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey

@Entity
data class ThumbnailEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val extension: String,
    val path: String
)
