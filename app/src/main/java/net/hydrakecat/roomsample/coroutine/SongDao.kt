package net.hydrakecat.roomsample.coroutine

import androidx.room.*

@Dao
interface SongDao {
  @Insert
  suspend fun insert(song: Song)

  @Update
  suspend fun update(song: Song)

  @Delete
  suspend fun delete(song: Song)

  @Query("SELECT * FROM Song")
  suspend fun findAll(): List<Song>
}
