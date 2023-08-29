package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SongsPage extends BasePage {

    public SongsPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver,wait,actions);
    }

   public void checkNumberOfSongsInPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".song-list-wrap.main-scroll-wrap.playlist td.title")));
        List<WebElement> allSongsInPlaylist =driver.findElements(By.cssSelector(".song-list-wrap.main-scroll-wrap.playlist td.title"));
       //This block is for visibility - printing all the songs
        for (WebElement element: allSongsInPlaylist)
        {
            System.out.println(element.getText());
        }
        Assert.assertEquals(allSongsInPlaylist.size(),3);
    }

    public void checkIfPlayBtnIsVisible() {
      WebElement playBtn =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
      Assert.assertTrue(playBtn.isDisplayed());
    }

    public void mouseMoveToPlayBtn() {
        WebElement playPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(playPanel).perform();
    }

    public void checkSongIsPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    public void clickPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playback"))).click();
    }

    public void contextClickSongByName(String songName)  {
        WebElement song =wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']")));
        actions.contextClick(song).perform();
    }

    public void clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }
}