@TuketiciKredisiHesaplama
Feature: Ziraat Bankası web sitesinden tuketici kredisi widget ekrani testi

  @TK-01-TuketiciKredisi-DijitalKredi-24-49999TL
  Scenario: Kredi tutari 49999 TL, Vade 24 ay
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Kredi hesaplama altındaki tuketici kredisine tiklanir
    When Tuketici kredisi turunu "Dijital Kredi (50.000 Tl'ye Kadar)" olarak secilir
    When Tuketici kredisi tutar degerine "49999" yazilir
    When Tuketici kredisi vade degerine "24" yazilir
    When Tuketici kredisi faiz degerine "4,54" yazilir
    Then Tuketici kredisi hesapla butonuna tiklar
    Then Tuketici kredisi hesaplama sonucu taksit tutari "3.947,87", faiz orani "4,54" ve yillik maliyet orani "100.4054" oldugu kontrol edilir

  @TK-02-TuketiciKredisi-DijitalKredi-24-50000TL
  Scenario: Kredi tutari 50000 TL, Vade 24 ay
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Kredi hesaplama altındaki tuketici kredisine tiklanir
    When Tuketici kredisi turunu "Dijital Kredi (50.000 Tl'ye Kadar)" olarak secilir
    When Tuketici kredisi tutar degerine "50000" yazilir
    When Tuketici kredisi vade degerine "24" yazilir
    When Tuketici kredisi faiz degerine "4,54" yazilir
    Then Tuketici kredisi hesapla butonuna tiklar
    Then Tuketici kredisi hesaplama sonucu taksit tutari "3.947,95", faiz orani "4,54" ve yillik maliyet orani "100.4054" oldugu kontrol edilir

  @TK-03-TuketiciKredisi-DijitalKredi-24-50001TL
  Scenario: Kredi tutari 50001 TL, Vade 24 ay
    Given Hesaplama araci gorunur oluncaya kadar beklenir
    Given Kredi hesaplama altındaki tuketici kredisine tiklanir
    When Tuketici kredisi turunu "Dijital Kredi (50.000 Tl'ye Kadar)" olarak secilir
    When Tuketici kredisi tutar degerine "50001" yazilir
    When Tuketici kredisi vade degerine "24" yazilir
    When Tuketici kredisi faiz degerine "4,54" yazilir
    Then Tuketici kredisi hesapla butonuna tiklar
    Then Tuketici kredisi hesaplama sonucu taksit tutari "3.947,95", faiz orani "4,54" ve yillik maliyet orani "100.4054" oldugu kontrol edilir