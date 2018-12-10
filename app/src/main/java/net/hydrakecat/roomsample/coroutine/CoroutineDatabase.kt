package net.hydrakecat.roomsample.coroutine

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class], version = 1)
abstract class CoroutineDatabase: RoomDatabase() {
  abstract fun songDao(): SongDao
}
