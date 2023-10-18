#languaje: es
Feature: Inicio de sesión

  Scenario: Inicio de sesión exitoso
    Given soy un usuario que ya está registrado
    When accedo con mis credenciales de logueo
    Then debo estar en el Home

