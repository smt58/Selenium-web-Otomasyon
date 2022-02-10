Feature: E-commerce

  Background:
    Given I initialize chrome driver
    When I go to "https://www.imdb.com/" url
    Then I see home page

  @test
  Scenario: Search Control
    Then I wait menu bar element 5 seconds
    When I click element: menu bar index: 1
    Then I click "PAGE_DOWN" keyboard button

    And I see search page
    When I wait oscars element 5 seconds
    When I click element: oscars index: 1
    When I click element: 1929 index: 1
    When I click element: the jazz singer index: 1

     # menuden yapılan arama sonuçları bir listeye eklenir
    Then I see search results page
    And I save director elementi listeye ekle:0
    And I save writer1 elementi listeye ekle:0
    And I save play elementi listeye ekle:0
    And I save writer2 elementi listeye ekle:0
    And I save adaptation elementi listeye ekle:0
    And I save writer3 elementi listeye ekle:0
    And I save titles elementi listeye ekle:0
    And I save star1 elementi listeye ekle:0
    And I save star2 elementi listeye ekle:0
    And I save star3 elementi listeye ekle:0


   #ana menuye dönünülür
    Then I see home page
    When I click element: anasayfa index: 1
    Then I wait search element 5 seconds
    When I send text "The Jazz Singer" to  "search" element
    Then I wait ok element 5 seconds
    When I click element: ok index: 1
    Then I wait Caz Mugannisi element 5 seconds
    When I click element: Caz Mugannisi index: 1

    #ana menuden yapılan arama sonuçları farklı bir listeye eklenir
    Then I see search results page
    And I save director elementi listeye ekle:1
    And I save writer1 elementi listeye ekle:1
    And I save play elementi listeye ekle:1
    And I save writer2 elementi listeye ekle:1
    And I save adaptation elementi listeye ekle:1
    And I save writer3 elementi listeye ekle:1
    And I save titles elementi listeye ekle:1
    And I save star1 elementi listeye ekle:1
    And I save star2 elementi listeye ekle:1
    And I save star3 elementi listeye ekle:1

    Then I see home page
    #iki arama sonucu liste olarak karşılaştırılır
    When I compare list

    When I click element: see all photos index: 1
    #broken image kontrol check edilir
    When I broken image detect


