package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

    // Tarayıcıyı başlat
    public static WebDriver getDriver() {
        if (driver == null) {
            // ChromeDriver'ı otomatik olarak indir ve ayarla
            WebDriverManager.chromedriver().clearDriverCache().setup();
            
            // Chrome ayarlarını yapılandır
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            
            // Yeni driver oluştur
            driver = new ChromeDriver(options);
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
