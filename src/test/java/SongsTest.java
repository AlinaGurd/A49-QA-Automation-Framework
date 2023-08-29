import org.testng.annotations.Test;

public class SongsTest extends BaseTest {

    @Test
    void contextClickOnSong()  {
        loginPage.loginCorrectCred();
        songsPage.clickAllSongs();
        songsPage.contextClickSongByName("Reactor");
        songsPage.clickPlay();
        songsPage.checkSongIsPlaying();
    }

    @Test
    void mouseHoverTest()  {
        loginPage.loginCorrectCred();
        songsPage.clickAllSongs();
        songsPage.mouseMoveToPlayBtn();
        songsPage.checkIfPlayBtnIsVisible();
    }
    @Test
    void checkPlaylistSongs()  {
        loginPage.loginCorrectCred();
        songsPage.clickOnPlaylist("Play List With Songs");
        songsPage.checkNumberOfSongsInPlaylist();
    }
}