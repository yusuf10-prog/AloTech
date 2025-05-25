package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    @FindBy(xpath = "//h1 | //div[contains(@class, 'hero')]//h1")
    private WebElement mainTitle;

    @FindBy(xpath = "//div[contains(text(), 'Çağrı')] | //h2[contains(text(), 'Çağrı')] | //p[contains(text(), 'Çağrı')] | //span[contains(text(), 'Çağrı')]")
    private WebElement cloudTitle;

    @FindBy(xpath = "//div[contains(@class, 'brands')] | //div[contains(text(), 'Marka')]")
    private WebElement brandsTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Ana sayfayı aç
    public void openHomePage() {
        driver.get("https://alotech.com.tr");
        try {
            Thread.sleep(10000); // Sayfanın yüklenmesi için daha uzun bir bekleme
            
            // Sayfanın tamamen yüklenmesini bekle
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            
            // JavaScript yüklenmesini bekle
            try {
                wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0"));
            } catch (Exception e) {
                // jQuery olmayabilir, bu durumu yok say
            }
            
            // Dinamik içeriğin yüklenmesi için ek bekleme
            Thread.sleep(5000);
            
            // Scroll yaptıktan sonra da bekle
            scrollToBottom();
            Thread.sleep(3000);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    // Sayfanın en altına in
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(1000); // Scroll işleminin tamamlanması için kısa bir bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
