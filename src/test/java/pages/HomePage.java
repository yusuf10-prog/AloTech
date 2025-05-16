package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    @FindBy(css = "h1")
    private WebElement mainTitle;

    @FindBy(css = ".hero-title")
    private WebElement cloudTitle;

    @FindBy(css = ".brands-title")
    private WebElement brandsTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Ana sayfayı aç
    public void openHomePage() {
        driver.get("https://alotech.com.tr/");
    }

    // Ana sayfa başlığını al
    public String getMainTitle() {
        return getText(mainTitle);
    }

    // Bulut başlığını al
    public String getCloudTitle() {
        return getText(cloudTitle);
    }

    // Markalar başlığını al
    public String getBrandsTitle() {
        return getText(brandsTitle);
    }
}
