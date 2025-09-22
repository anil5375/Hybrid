package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utilities.BaseClass.driver;

public class Locators {
    public static void main(String[] args) {
  //      WebDriverManager.chromedriver().setup();
    //    WebDriverManager.chromedriver().browserVersion("140.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        System.out.println("Title" +driver.getTitle());

        Select ele = new Select(driver.findElement(By.id("course")));
        ele.selectByVisibleText("Java");
        //ele.selectByValue("Python");
       // ele.selectByIndex(3);
        //WebElement option = ele.getFirstSelectedOption();
        //System.out.println(option.getText());
      /*  List<WebElement> allOptions = ele.getOptions();
        System.out.println("Total options: " + allOptions.size());
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }*/
        //driver.findElement(By.name("q")).clear();
        //ele.sendKeys("Selenium");
        //ele.sendKeys(Keys.ENTER);
        //driver.findElement(By.name("q")).sendKeys("Selenium");
        //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //driver.findElement(By.linkText("Gmail")).click();
        //driver.findElement(By.partialLinkText("mail")).click();
        //driver.findElement(By.id("gbqfq")).sendKeys("Selenium");
        //driver.findElement(By.id("gbqfq")).sendKeys(Keys.ENTER);
        //driver.findElement(By.className("gbqfif")).sendKeys("Selenium");
        //driver.findElement(By.className("gbqfif")).sendKeys(Keys.ENTER);
        //driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Selenium");
        //driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//input[@class='gLFyf

        //driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        //driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
       // By email = (By.linkText("My Account"));
        //driver.findElement(By.linkText("Register")).click();
        //   driver.quit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     /*  WebElement element =
               wait.until(ExpectedConditions.presenceOfElementLocated(email));
*/
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

  /*  public WebDriver launchBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            driver.getTitle();
            return driver;
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            driver.getTitle();
            return driver;
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            driver.getTitle();
            return driver;
        }
         return driver;

    }*/
}