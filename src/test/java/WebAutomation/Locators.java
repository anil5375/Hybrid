package WebAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //ChromeDriver options = new ChromeDriver();
        //options
        WebDriver driver = new ChromeDriver();
    driver.get("https://moneycontrol.com/");
    driver.manage().window().maximize();

    //driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
    //driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
   // driver.findElement(By.linkText("My Account")).click();
    //driver.findElement(By.linkText("Register")).click();
 //   driver.quit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

        // Press the Escape key
        //actions.sendKeys(Keys.ESCAPE).perform();
       // driver.navigate().refresh();
        actions.sendKeys(Keys.ESCAPE).perform();
       // driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).isDisplayed();
       // actions.sendKeys(Keys.ESCAPE).perform();
      //  driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).click();
        //driver.close();
    }



}
