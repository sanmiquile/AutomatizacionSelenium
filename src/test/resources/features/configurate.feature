Feature: Configuracion SMS

  Scenario: Configuracion SMS exitoso
    Given soy un usuario autenticado
    And estoy en el paso de "Configurar SMS"
    When creo el codigo y descripcion del proyecto
    Then debo pasar a la página de Objetivos

