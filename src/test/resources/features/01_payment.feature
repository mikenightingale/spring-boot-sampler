Feature: Post payment

  Scenario: Test 1
    When I send a payment:
      | bic        | iban            | currency | amount |
      | DE01234567 | DE1234567891011 | EUR      | 100    |
      | DE01234567 | DE1234567891012 | EUR      | 9      |
      | DE01234567 | DE1234567891012 | EUR      | 8      |