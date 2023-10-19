#languaje: es
Feature: Registro de usuario

  Scenario: Registro exitoso
    Given soy un usuario no registrado
    When ingreso mis datos de afiliacion y me registro
    Then muestra mensaje de operación completada

  Scenario: Registro duplicado
    Given soy un usuario que ya estaba registrado
    When ingreso mis datos de afiliacion y me registro
    Then muestra mensaje de que ya existe el registro

