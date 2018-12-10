package net.hydrakecat.roomsample.coroutine

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CoroutineSongDaoTest {
  private lateinit var songDao: SongDao
  private lateinit var db: CoroutineDatabase

  @Before
  fun setup() {
    db = Room.databaseBuilder(ApplicationProvider.getApplicationContext(),
        CoroutineDatabase::class.java, "coroutine-database")
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
    GlobalScope.launch {
      val songs = withContext(Dispatchers.IO) {
        songDao.insert(Song(1, "https://example.com/1"))
        songDao.insert(Song(2, "https://example.com/2"))
        songDao.findAll()
      }

      println(songs)
      assertEquals(2, songs.size)
    }
  }
}
