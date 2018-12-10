package net.hydrakecat.roomsample.rx

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single
import net.hydrakecat.roomsample.views.Song

interface SongDao {
  @Insert
  fun insert(song: Song): Completable

  @Update
  fun update(song: Song): Single<Int>

  @Delete
  fun delete(song: Song): Completable
}
