package Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Windowhandle {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        System.out.println("Title" + driver.getTitle());
        driver.findElement(By.id("newWindowBtn")).click();
        String parentWindowHandle = driver.getWindowHandle();
        Set<String>  windowHandles= driver.getWindowHandles();
        System.out.println("Parent window handle: " + parentWindowHandle);
        System.out.println("All window handles: " + windowHandles);
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to window handle: " + handle);
                System.out.println("Title of the new window: " + driver.getTitle());
                driver.close(); // Close the child window
            }
        }
        driver.switchTo().window(parentWindowHandle);
        System.out.println("Switched back to parent window: " + parentWindowHandle);
        driver.quit(); // Close the parent window and end the session


    }

}
