package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;

import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;
    public static ExtentReports extent;
    public static ExtentTest test;
    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser"})
    public void setup(
            @Optional("windows") String os,
            @Optional("chrome") String br)
            throws IOException {

        // Load config.properties
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        String executionEnv = p.getProperty("execution_env");

        if ("remote".equalsIgnoreCase(executionEnv)) {
            setupRemoteDriver(os, br);
        } else if ("local".equalsIgnoreCase(executionEnv)) {
            setupLocalDriver(br);
        } else {
            throw new IllegalArgumentException("Invalid execution_env value in config.properties");
        }

        if (driver == null) {
            throw new IllegalStateException("WebDriver initialization failed.");
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL2"));
        driver.manage().window().maximize();

        logger.info("Browser launched: " + br + ", OS: " + os);
    }

    private void setupRemoteDriver(String os, String br) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // OS
        switch (os.toLowerCase()) {
            case "windows":
                capabilities.setPlatform(Platform.WINDOWS); break;
            case "linux":
                capabilities.setPlatform(Platform.LINUX); break;
            case "mac":
                capabilities.setPlatform(Platform.MAC); break;
            default:
                throw new IllegalArgumentException("Unsupported OS: " + os);
        }

        // Browser
        switch (br.toLowerCase()) {
            case "chrome":
                capabilities.setBrowserName("chrome"); break;
            case "edge":
                capabilities.setBrowserName("MicrosoftEdge"); break;
            case "firefox":
                capabilities.setBrowserName("firefox"); break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + br);
        }

        String gridURL = p.getProperty("gridURL");
        driver = new RemoteWebDriver(new URL(gridURL), capabilities);
    }

    private void setupLocalDriver(String br) {
        switch (br.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(); break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(); break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(); break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + br);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed.");
        }
    }

    // Utility methods

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomNumeric(3);
    }

    public String captureScreen(String testName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        File target = new File(screenshotDir + testName + "_" + timestamp + ".png");

        FileUtils.copyFile(source, target);
        logger.info("Screenshot captured: " + target.getAbsolutePath());

        return target.getAbsolutePath();
    }
}
