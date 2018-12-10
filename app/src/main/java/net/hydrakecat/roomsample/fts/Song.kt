package net.hydrakecat.roomsample.fts

import androidx.room.*

@Entity
data class Song(
    @PrimaryKey
    val id: Long,
    val url: String,
    @Embedded
    val labels: SongLabels
)

data class SongLabels(
    val songName: String,
    val albumName: String,
    val artistName: String
)

@Entity
@Fts4(contentEntity = Song::class)
data class SongFts(@Embedded val labels: SongLabels)

@Entity
@Fts4(languageId = "lid")
data class Product(
    @ColumnInfo(name = "lid") val languageId: Int
)
