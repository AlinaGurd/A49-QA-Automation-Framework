package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver,WebDriverWait wait,Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }
    public void quitBrowser(){driver.quit();}
    public void navigateToPage(String url) {
        driver.get(url);
    }
    public void clickSubmit() {
        clickOnElement(By.cssSelector("[type='submit']"));
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    void clickOnElement(By locator){
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    void enterText(By locator, String text){
        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    private void clickOnOk() {
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        okBtn.click();
    }

    protected void checkShowSuccess() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
       Assert.assertTrue(notification.isDisplayed());
    }

    public void clickOnPlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }
}
