#languaje: es
Feature: Registro de usuario

  Scenario: Registro exitoso
    Given soy un usuario no registrado
    When ingreso mis datos de afiliacion y me registro
    Then muestra mensaje de operación completada


