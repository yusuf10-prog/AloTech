# AloTech Test Otomasyon Projesi

Bu proje, AloTech web sitesinin (https://alotech.com.tr/) test otomasyonunu içermektedir.

## Kullanılan Teknolojiler

- Java 11
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Maven

## Proje Yapısı

- `src/test/java/pages`: Page Object Model sınıfları
- `src/test/java/stepdefinitions`: Cucumber step tanımlamaları
- `src/test/java/utils`: Yardımcı sınıflar
- `src/test/resources/features`: Cucumber feature dosyaları

## Kurulum

1. Java 11 JDK'yı yükleyin
2. Maven'i yükleyin
3. Projeyi klonlayın: `git clone https://github.com/yusuf10-prog/AloTech.git`
4. Proje dizinine gidin: `cd AloTech`
5. Bağımlılıkları yükleyin: `mvn clean install`

## Testleri Çalıştırma

```bash
mvn clean test
```

## Test Senaryoları

1. Ana Sayfa Testleri
   - Ana sayfa başlığı kontrolü
   - "Türkiye'nin En Büyük Çağrı Merkezi Bulutu" yazısı kontrolü
   - "700'den Fazla Marka AloTech'e Güveniyor" yazısı kontrolü
