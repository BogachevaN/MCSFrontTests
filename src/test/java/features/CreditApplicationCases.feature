@all
Feature: loan application in CFT-Front

  Scenario: operator authorizaition
    Given open 'http://localhost:4200/login'
    When fill input field 'Логин' text: "TEST1"
    And fill input field 'Пароль' text: "12345"
    And click button login
    Then operator's page 'http://localhost:4200/operator' opens

  Scenario: search client
    Given page 'http://localhost:4200/operator' opens
    When fill input field 'Поиск' text: "Собянина"
    And select first client in list
    Then open client identification

  Scenario: client identification
    Given window client identifications opens
    When automatic check successfully
    And click button 'Далее'
    Then open page with products

  Scenario:  create loan application
    Given client profile opens
    When input loan parameters
    And select product 'Престиж'
    Then client form opens

  Scenario: express assessment
    Given client form opens
    When fill passport data
    And  fill personal information
    And  fill registration address
    And fill residence address
    And fill contacts
    And click button 'Печать'
    And click 'Экспресс-оценка'
    Then 'Заявка предварительно одобрена'

  Scenario:
    Given 'Заявка предварительно одобрена'
    When click 'Заполнить форму'
    And fill all fields
    And click 'Отправить на андеррайтинг'
    Then 'отправлено на андеррайтинг'



  Scenario: operator logout
     Given page 'http://localhost:4200/operator' opens
     When click on user icon
     And click 'Выйти'
     Then page 'http://localhost:4200/login' opens
