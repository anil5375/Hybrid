package WebAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableCheckbox {


   static WebDriver driver;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        selectEmp("Joe.Root");
        selectEmp("John.Smith");

    }


    public static void selectEmp(String name){
        // https://selectorshub.com/xpath-practice-page/
        //a[text()='Joe.Root']/parent::td/preceding-sibling::td/child::input

     WebElement checkBox = driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/child::input"));
        checkBox.click();
    }
}
