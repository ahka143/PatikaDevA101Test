Feature: Kullanici A101 mobile sitesine uye olmadan alisveris yapabilir

  @Mobile
  Scenario: Kullanici A101 mobile sitesine uye olmadan alisveris yapabilir

    Given Kullanici A101 mobile anasayfasina gider
    And Kullanici menu butonuna tiklar
    And Kullanici Giyim Aksesuar menusune tiklar
    And Kullanici Kadin ic giyim menusune tiklar
    And Kullanici Dizalti Corap menusune tiklar
    And Kullanici ilk urunu secer
    Then Kullanici secilen urunun renginin siyah oldugunu dogrular
    And Kullanici sepete ekle butonuna tiklar
    And Kullanici mobilde "Sepeti Görüntüle" butonuna tiklar
    And Kullanici mobilde "Sepeti Onayla" butonuna tiklar
    And Kullanici mobil "ÜYE OLMADAN DEVAM ET" butonuna tiklar
    And Kullanici mobilde gecerli bir mail adresi girer ve Devam et butonuna tiklar
    And Kullanici mobilde yeni adres olustur butonuna tiklar
    And Kullanici mobilde yeni adres bilgilerini girer ve kaydet butonuna tiklar
    And Kullanici mobil "KAYDET" butonuna tiklar
    And Kullanici mobil "Sendeo" butonuna tiklar
    And Kullanici mobil "Kaydet ve Devam Et" butonuna tiklar
    Then Kullanici odeme ekraninda oldugunu dogrular
    And Kullanici mobil sayfayi kapatir