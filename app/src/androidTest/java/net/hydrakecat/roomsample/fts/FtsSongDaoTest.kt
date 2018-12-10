package net.hydrakecat.roomsample.fts

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class FtsSongDaoTest {
  private lateinit var songDao: SongDao
  private lateinit var db: FtsDatabase

  @Before
  fun setup() {
    db = Room.databaseBuilder(
        ApplicationProvider.getApplicationContext(),
        FtsDatabase::class.java,
        "test-database"
    ).allowMainThreadQueries().build()
    songDao = db.songDao()
  }

  @After
  @Throws(IOException::class)
  fun teardown() {
    db.close()
  }

  @Test
  fun testSearchSongs() {
    songDao.insert(Song(
        id = 1,
        url = "https://example.com/song/1",
        labels = SongLabels(
            songName = "Prelude in E Minor",
            albumName = "Night Lights",
            artistName = "Gerry Mulligan"
        )
    ))

    val list1 = songDao.searchSongs("gerry")
    assertEquals(1, list1.size)

    val list2 = songDao.searchSongs("gerry OR hoge")
    assertEquals(1, list2.size)
  }
}

