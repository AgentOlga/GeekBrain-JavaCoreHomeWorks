Feature: Добавление товара в корзину

  Background:
    Given User authorized

  @hooks
    @close
  Scenario Outline:
    When Click TShirts button in women suggest
    When Select size '<size>'
    And choose tshirt by text '<name>'
    Then cart summ should be correct
    Examples:
      | size | name  |
      | S    | faded |
      | M    | ed    |

