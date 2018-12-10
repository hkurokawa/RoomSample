package net.hydrakecat.roomsample.rx

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class], version = 1)
abstract class RxDatabase: RoomDatabase() {
  abstract fun songDao(): SongDao
}
