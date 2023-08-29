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
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import pages.SongsPage;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    BasePage basePage ;
    LoginPage loginPage;
    SongsPage songsPage ;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void initTest() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        //instantiate Explicit wait
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        actions = new Actions(driver);
        basePage = new BasePage(driver,wait,actions);
        basePage.navigateToPage("https://qa.koel.app/");
        loginPage = new LoginPage(driver,wait,actions);
        songsPage = new SongsPage(driver,wait,actions);
    }

    @AfterClass
    public void teardown() {
        basePage.quitBrowser();
    }
//
//    public void navigateToPage() {
//        driver.get(url);
//    }
//
//    public void provideEmail(String email) {
//        enterText(By.cssSelector("input[type='email']"),email);
//    }
//
//    public void providePassword(String password) {
//        enterText(By.cssSelector("input[type='password']"),password);
//    }
//
//    public void clickSubmit() {
//        clickOnElement(By.cssSelector("[type='submit']"));
//    }
//
//    public String generateRandomName() {
//        return UUID.randomUUID().toString().replace("-", "");
//    }
//    protected void loginCorrectCred() {
//        navigateToPage();
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//    }
//
//    void clickOnElement(By locator){
//        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
//        el.click();
//    }
//    void enterText(By locator, String text){
//        WebElement el= wait.until(ExpectedConditions.elementToBeClickable(locator));
//        el.click();
//        el.clear();
//        el.sendKeys(text);
//    }
//
//    private void clickOnOk() {
//        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
//        okBtn.click();
//    }
//
//    protected void checkShowSuccess() {
//        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//       Assert.assertTrue(notification.isDisplayed());
//    }
//
//    protected void clickOnPlaylist(String playlistName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
//    }
}
