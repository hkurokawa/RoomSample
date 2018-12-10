package net.hydrakecat.roomsample.views

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
class ViewsSongDaoTest {
  private lateinit var songDao: SongDao
  private lateinit var db: ViewsDatabase

  @Before
  fun setup() {
    db = Room.databaseBuilder(ApplicationProvider.getApplicationContext(),
        ViewsDatabase::class.java, "view-database")
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
    songDao.insert(Song(
        songId = 1,
        name = "Prelude in E Minor",
        popularity = 100
    ))
    songDao.insert(Album(
        albumId = 1,
        title = "Night Lights"
    ))
    songDao.insert(AlbumSong(
        songId = 1,
        albumId = 1
    ))

    val list = songDao.allSongsAndAlbums()
    assertEquals("Night Lights", list[0].album_title)
    assertEquals("Prelude in E Minor", list[0].song_name)
  }
}


