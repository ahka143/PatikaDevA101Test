Feature: Kullanici A101 sitesine uye olmadan alisveris yapabilir

  @Test1
  Scenario: TC01 Kullanici A101 sitesine uye olmadan alisveris yapabilir
    Given Kulllanici "a101Url" anasayfasina gider
    And Kullanici cerezleri kabul eder
    And Kullanici Kategoriler butonunu tiklar
    And Kullanici Giyim aksesuar butonuna tiklar
    And Kullanici "Kadın İç Giyim" butonuna tiklar
    And Kullanici "Dizaltı Çorap" butonuna tiklar
    And Kullanici ilk urune tiklar
    Then Kullanici urun renginin "SİYAH" oldugunu dogrular
    And Sepete ekle butonuna tiklar
    And Kullanici Sepeti Goruntule butonuna tiklar
    And Kullanici "Sepeti Onayla" butonuna tiklar
    And Kullanici "ÜYE OLMADAN DEVAM ET" butonuna tiklar
    And Kullanici gecerli bir mail adresi girer ve Devam et butonuna tiklar
    And Kullanici "Yeni adres oluştur" butonuna tiklar
    And Kullanici gerekli alanlari doldurur ve kaydet butonuna tiklar
    And Kullanici kaydet ve devam et butonununa tiklar
    Then Kullanici odeme ekranina gidildigii dogrular
    And Kullanici sayfayi kapatir

