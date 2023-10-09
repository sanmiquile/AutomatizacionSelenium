#languaje: es
Feature: Inicio de sesión

  Scenario: Inicio de sesión exitoso
    Given estoy en la página de inicio de sesión del SMS Builder
    When mi nombre de usuario válido y mi contraseña válida
    And hago clic en el botón Ingresar
    Then debería estar en el Home

  Scenario: Inicio de sesión no exitoso
    Given estoy en la página de inicio de sesión del SMS Builder
    When mi nombre de usuario inválido y mi contraseña válida
    And hago clic en el botón Ingresar
    Then debería estar en el Home

  Scenario: Inicio de sesión no exitoso
    Given estoy en la página de inicio de sesión del SMS Builder
    When mi nombre de usuario valida y mi contraseña vacía
    And hago clic en el botón Ingresar
    Then debería estar en el Home