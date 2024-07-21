@IbanHesaplama
Feature: Ziraat Bankası web sitesinden iban hesaplama widget ekrani testi

  @IH-01-IbanHesaplama-436-123456789-1234
  Scenario: Sube kodlara gore 436, Musteri No 123456789, Ek no 1234
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Iban hesaplamaya tiklanir
    When Iban hesaplama sube kodlarina gore sirala checkboxina tiklanir
    When Iban hesaplama "436" kodlu sube secilir
    When Iban hesaplama musteri no "123456789" yazilir
    When Iban hesaplama ek no "1234" yazilir
    Then Iban hesaplama hesapla butonuna tiklar
    Then Iban hesaplama sonucu iban degeri "TR470001009012345678901234" oldugu kontrol edilir

  @IH-02-IbanHesaplama-2515-Null-Null
  Scenario: Sube kodlara gore 2515, Musteri No null, Ek no null
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Iban hesaplamaya tiklanir
    When Iban hesaplama sube kodlarina gore sirala checkboxina tiklanir
    Then Iban hesaplama hesapla butonuna tiklar
    Then Iban hesaplama musteri no bilgisi ve ek no bilgisi bos birakilamaz uyarilarinin goruntulenmesi kontrol edilir

  @IH-03-IbanHesaplama-436-1234567-123
  Scenario: Sube kodlara gore 436, Musteri No 1234567, Ek no 123
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Iban hesaplamaya tiklanir
    When Iban hesaplama sube kodlarina gore sirala checkboxina tiklanir
    When Iban hesaplama "436" kodlu sube secilir
    When Iban hesaplama musteri no "1234567" yazilir
    When Iban hesaplama ek no "123" yazilir
    Then Iban hesaplama hesapla butonuna tiklar
    Then Iban hesaplama musteri no bilgisi ve ek no bilgisi eksik girilmistir uyarilarinin goruntulenmesi kontrol edilir

  @IH-04-IbanHesaplama-AHLAT-123456789-1234
  Scenario: Sube isimlerine gore AHLAT, Musteri No 123456789, Ek no 1234
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Iban hesaplamaya tiklanir
    When Iban hesaplama "AHLAT/BİTLİS ŞUBESİ-(271)" kodlu sube isim secilir
    When Iban hesaplama musteri no "123456789" yazilir
    When Iban hesaplama ek no "1234" yazilir
    Then Iban hesaplama hesapla butonuna tiklar
    Then Iban hesaplama sonucu iban degeri "TR470001009012345678901234" oldugu kontrol edilir

  @IH-05-IbanHesaplama-2515-Null-Null
  Scenario: Sube isimlerine gore sanayi/izmir, Musteri No null, Ek no null
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Iban hesaplamaya tiklanir
    Then Iban hesaplama hesapla butonuna tiklar
    Then Iban hesaplama musteri no bilgisi ve ek no bilgisi bos birakilamaz uyarilarinin goruntulenmesi kontrol edilir

  @IH-06-IbanHesaplama-AHLAT-1234567-123
  Scenario: Sube isimlerine gore AHLAT, Musteri No 1234567, Ek no 123
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Iban hesaplamaya tiklanir
    When Iban hesaplama "AHLAT/BİTLİS ŞUBESİ-(271)" kodlu sube isim secilir
    When Iban hesaplama musteri no "1234567" yazilir
    When Iban hesaplama ek no "123" yazilir
    Then Iban hesaplama hesapla butonuna tiklar
    Then Iban hesaplama musteri no bilgisi ve ek no bilgisi eksik girilmistir uyarilarinin goruntulenmesi kontrol edilir