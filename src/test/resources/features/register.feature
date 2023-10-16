#languaje: es
Feature: Registro de usuario

  Scenario: Registro exitoso
    Given estoy en la página de inicio de sesión del SMS Builder
    When presistiono el botón de Regrar
    And ingresao datos válidos de nombre, usuario, contraseña y confirmación de contraseña
    And hago clic en el botón Aceptar
    Then muestra mensaje de operación completada


  Scenario: Registro duplicado
    Given estoy en la página de inicio de sesión del SMS Builder
    When presiono el botón de Registrar
    And ingresao datos existentes de nombre, usuario, contraseña y confirmación de contraseña
    And hago clic en el botón Aceptar
    Then muestra mensaje indicando que ya existe el registro

  Scenario: Registro no exitoso
    Given estoy en la página de inicio de sesión del SMS Builder
    When presiono el botón de Registrar

