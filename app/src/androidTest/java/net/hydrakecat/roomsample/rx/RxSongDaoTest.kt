package net.hydrakecat.roomsample.rx

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RxSongDaoTest {
  private lateinit var songDao: SongDao
  private lateinit var db: RxDatabase

  @Before
  fun setup() {
    db = Room.databaseBuilder(ApplicationProvider.getApplicationContext(),
        RxDatabase::class.java, "rx-database")
        .allowMainThreadQueries()
        .build()
    songDao = db.songDao()
  }

  @After
  @Throws(IOException::class)
  fun teardown() {
    db.close()
  }

  @Test
  fun test() {
    val song = Song(1, "https://example.com/1")
    songDao.insert(song)
        .test()
        .await()
        .assertComplete()
    songDao.find(1)
        .test()
        .await()
        .assertValue(song)
    songDao.update(song.copy(url = "https://example.com/11"))
        .test()
        .await()
        .assertValue(1)
    songDao.delete(song)
        .test()
        .await()
        .assertComplete()
    songDao.find(1)
        .test()
        .await()
        .assertComplete()
        .assertNoValues()
  }
}
