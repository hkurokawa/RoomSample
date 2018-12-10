package net.hydrakecat.roomsample.rx

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface SongDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(song: Song): Completable

  @Update
  fun update(song: Song): Single<Int>

  @Delete
  fun delete(song: Song): Completable

  @Query("SELECT * FROM Song WHERE id = :id")
  fun find(id: Long): Maybe<Song>
}
