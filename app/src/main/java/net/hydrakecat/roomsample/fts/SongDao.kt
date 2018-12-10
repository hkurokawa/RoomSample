package net.hydrakecat.roomsample.fts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(song: Song)

//  @Query("""
//    SELECT *
//    FROM Song
//    WHERE songName LIKE '%' || :query || '%'
//    OR albumName LIKE '%' || :query || '%'
//    OR artistName LIKE '%' || :query || '%'
//    """)
//  fun searchSongs(query: String): List<Song>

//  @Query("""
//    SELECT *
//    FROM Song
//    WHERE Song MATCH :query
//    """)
//  fun searchSongs(query: String): List<Song>

  @Query("""
    SELECT Song.* FROM SongFts JOIN Song ON SongFts.rowid = id
    WHERE SongFts MATCH :query
    """)
  fun searchSongs(query: String): List<Song>
}