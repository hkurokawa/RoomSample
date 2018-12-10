package net.hydrakecat.roomsample.views

import androidx.room.*


@Entity(primaryKeys = ["song_id", "album_id"])
data class AlbumSong(
    @ColumnInfo(name = "song_id")
    val songId: Int,
    @ColumnInfo(name = "album_id")
    val albumId: Int
)

@Entity
data class Album(
    @PrimaryKey
    @ColumnInfo(name = "album_id")
    val albumId: Int,
    val title: String
)

@Entity
data class Song(
    @PrimaryKey
    @ColumnInfo(name = "song_id")
    val songId: Int,
    val name: String,
    val popularity: Int
)

@DatabaseView(
    """
   SELECT Album.*, Song.* FROM AlbumSong
   INNER JOIN Album ON Album.album_id = AlbumSong.album_id
   INNER JOIN Song ON Song.song_id = AlbumSong.song_id
   """)
data class AlbumSongFull(
    @Embedded
    val song: Song,
    @Embedded
    val album: Album
)