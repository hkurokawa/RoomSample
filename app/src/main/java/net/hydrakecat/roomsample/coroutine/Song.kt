package net.hydrakecat.roomsample.coroutine

import androidx.room.*

@Entity
data class Song(
    @PrimaryKey
    val id: Long,
    val url: String
)