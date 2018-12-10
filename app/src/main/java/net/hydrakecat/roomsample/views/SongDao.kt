package net.hydrakecat.roomsample.views

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(song: Song)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(album: Album)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(albumSong: AlbumSong)

//  @Query("""
//   SELECT Album.title AS album_title, Song.name AS song_name FROM AlbumSong
//   INNER JOIN Album ON Album.album_id = AlbumSong.album_id
//   INNER JOIN Song ON Song.song_id = AlbumSong.song_id
//   """)
//  fun allSongsAndAlbums(): List<Listing>

  @Query("""
   SELECT name AS song_name, title AS album_title FROM AlbumSongFull
  """)
  fun allSongsAndAlbums(): List<Listing>
}

data class Listing(val album_title: String, val song_name: String)
