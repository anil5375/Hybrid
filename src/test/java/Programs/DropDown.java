package Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        System.out.println("Title" +driver.getTitle());


        Select ele = new Select(driver.findElement(By.id("course")));
        ele.selectByVisibleText("Java");
      /*  ele.selectByValue("Python");
         ele.selectByIndex(3);
        WebElement option = ele.getFirstSelectedOption();
        System.out.println(option.getText());
        List<WebElement> allOptions = ele.getOptions();
        System.out.println("Total options: " + allOptions.size());
        for (WebElement options : allOptions) {
            System.out.println(options.getText());
        }*/
    }
}
