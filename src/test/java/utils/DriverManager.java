package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

    // Tarayıcıyı başlat
    public static WebDriver getDriver() {
        if (driver == null) {
            // ChromeDriver'ı otomatik olarak indir ve ayarla
            WebDriverManager.chromedriver().setup();
            
            // Chrome ayarlarını yapılandır
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-extensions");
            
            // Yeni driver oluştur
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Tarayıcıyı kapat
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
