package stepdefinitions;

import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Ozaman;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;
import pages.HomePage;
import utils.DriverManager;

public class HomePageSteps {
    private HomePage homePage = new HomePage(DriverManager.getDriver());

    @Diyelimki("AloTech ana sayfasına gittim")
    public void anaGittim() {
        homePage.openHomePage();
    }

    @Ozaman("ana sayfa başlığını görmeliyim")
    public void baslikKontrol() {
        String baslik = homePage.getMainTitle();
        Assert.assertTrue("Ana sayfa başlığı görüntülenemedi!", baslik != null && !baslik.isEmpty());
    }

    @Ve("ana sayfada {string} yazısını görmeliyim")
    public void yaziKontrol(String beklenenYazi) {
        homePage.scrollToBottom(); // Sayfanın en altına in
        try {
            Thread.sleep(2000); // Scroll sonrası elementlerin yüklenmesi için bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String bulunanYazi;
        if (beklenenYazi.contains("Çağrı Merkezi")) {
            bulunanYazi = homePage.getCloudTitle();
        } else {
            bulunanYazi = homePage.getBrandsTitle();
        }
        Assert.assertTrue("Beklenen yazı görüntülenemedi: " + beklenenYazi, 
            bulunanYazi != null && bulunanYazi.contains(beklenenYazi));
    }
}
