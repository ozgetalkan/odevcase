@MevduatGetirisiHesaplama
Feature: Ziraat Bankası web sitesinden mevduat getirisi hesaplama widget ekrani testi

  @MGH-01-MevuatGetirisiHesaplama-TL-730-1000TL
  Scenario: Doviz cinsi TL, Vade suresi 730 gun, Tutar 1000 TL
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Mevduat getirisi hesaplamaya tiklanir
    When Mevduat getirisi hesaplama doviz cinsi "TL" olarak secilir
    When Mevduat getirisi hesaplama vade suresine "730" yazilir
    When Mevduat getirisi hesaplama tutar degerine "1000" yazilir
    Then Mevduat getirisi hesaplama hesapla butonuna tiklar
    Then Mevduat getirisi hesaplama sonucu vade sonu tutari "1.126,67" ve faiz orani "6,5" oldugu kontrol edilir

  @MGH-02-MevuatGetirisiHesaplama-TL-730-NullTL
  Scenario: Doviz cinsi TL, Vade suresi 730 gun, Tutar null TL
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Mevduat getirisi hesaplamaya tiklanir
    When Mevduat getirisi hesaplama doviz cinsi "TL" olarak secilir
    When Mevduat getirisi hesaplama vade suresine "730" yazilir
    Then Mevduat getirisi hesaplama hesapla butonuna tiklar
    Then Mevduat getirisi hesaplama tutar bilgisi bos birakilamaz uyarisinin goruntulenmesi kontrol edilir