package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Ozaman;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;
import pages.HomePage;
import utils.DriverManager;

public class HomePageSteps {
    private HomePage homePage;

    @Before
    public void setup() {
        homePage = new HomePage(DriverManager.getDriver());
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

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
