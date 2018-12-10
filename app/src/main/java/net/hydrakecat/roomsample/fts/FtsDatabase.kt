package net.hydrakecat.roomsample.fts

import androidx.room.Database
import androidx.room.RoomDatabase
import net.hydrakecat.roomsample.fts.*

@Database(entities = [Song::class, SongFts::class, Product::class], version = 1)
abstract class FtsDatabase: RoomDatabase() {
  abstract fun songDao(): SongDao
}
