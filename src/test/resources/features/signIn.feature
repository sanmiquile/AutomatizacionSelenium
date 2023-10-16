#languaje: es
Feature: Inicio de sesión

  Scenario: Inicio de sesión exitoso
    Given estoy en la página de inicio de sesión del SMS Builder
    And soy un usuario que ya está registrado
    When accedo con mis credenciales de logueo
    Then debo estar en el Home

  Scenario: Inicio de sesión no exitoso
    Given estoy en la página de inicio de sesión del SMS Builder
    When mi nombre de usuario inválido y mi contraseña válida
    And hago clic en el botón Ingresar
    Then Muestra mensaje de error

  Scenario: Inicio de sesión campos vacíos
    Given estoy en la página de inicio de sesión del SMS Builder
    When mi nombre de usuario valida y mi contraseña vacía
    And hago clic en el botón Ingresar
    Then muestra mensaje de error

  Scenario: Ingresar al home sin inicar sesión
    Given la url del home
    When ingreso al navegador y pego la url
    Then me lleva a la página de inicio de sesión del SMS Builder