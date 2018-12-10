package net.hydrakecat.roomsample.rx

import androidx.room.*

@Entity
data class Song(
    @PrimaryKey
    val id: Long,
    val url: String
)