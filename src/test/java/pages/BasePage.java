package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final int WAIT_TIMEOUT = 10;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT)); // 10 saniye bekleme süresi
        PageFactory.initElements(driver, this);
    }

    // Elementin görünür olmasını bekle
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Elemente tıkla
    protected void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    // Yazı yaz
    protected void sendText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    // Yazı oku
    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }
}
