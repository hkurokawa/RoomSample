package net.hydrakecat.roomsample.views

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Song::class, Album::class, AlbumSong::class],
    views = [AlbumSongFull::class],
    version = 1
)
abstract class ViewsDatabase: RoomDatabase() {
  abstract fun songDao(): SongDao
}

